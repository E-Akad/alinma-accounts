package com.alinma.rib.accounts.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.alinma.rib.accounts.model.response.AccountStatementInquiryResponse;
import com.alinma.rib.accounts.model.response.AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo;
import com.alinma.rib.accounts.model.response.AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo;
import com.alinma.rib.accounts.model.response.Amount;
import com.alinma.rib.accounts.model.response.TransactionModelDownloadReport;
import com.alinma.rib.accounts.model.response.TransactionType;
import com.alinma.rib.accounts.model.response.VatInvoiceDetailsResponse;
import com.alinma.rib.accounts.model.response.VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo;
import com.alinma.rib.accounts.util.GeneralUtil;
import com.alinma.rib.authentication.model.system.CombinedDate;
import com.alinma.rib.report.ReportFormat;
import com.alinma.rib.service.report.InmaReportService;
import com.alinma.rib.service.user.UserService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleCsvExporterConfiguration;
import net.sf.jasperreports.export.SimpleDocxReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

@Service
@Configuration
@PropertySource("classpath:/reports/presentationMessages_en.properties")
@PropertySource("classpath:/reports/presentationMessages_ar.properties")
public class ReportingService {

	private static Logger logger = LoggerFactory.getLogger(ReportingService.class);
	
	@Autowired
	UserService userService;

	@Autowired
	Environment env;
	@Autowired
	InmaReportService  inmaReportService;


	
	public String generateReport(String reportName, String reportData) {
		return "reportStream";
	}

	public String generateTransactionReport(Long accountNumber, String extension, 
	AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo transactionInfo,
	VatInvoiceDetailsResponse vatInvoiceDetailsInquiry, String customerName, String customerAddress) throws IOException {
		String report = "";
		try {
			
			InputStream reportInputStream = getClass().getResourceAsStream("/reports/invoicePrintReport.jasper");
			
			Map<String, Object> parameters = new HashMap<>();
			
			parameters = fillTransactionsParameters(accountNumber,transactionInfo,vatInvoiceDetailsInquiry,customerName,customerAddress);
			
			JasperPrint jasperPrint = null;
			
			if(vatInvoiceDetailsInquiry != null && vatInvoiceDetailsInquiry.getVatInvoiceDetailsInquiryRs() != null 
			&& vatInvoiceDetailsInquiry.getVatInvoiceDetailsInquiryRs().getVatInvoiceDetailsList() != null){
				
				List<VatinvoicedetailsresponseVatInvoiceDetailsInquiryRsVatInvoiceDetailsListVatInvoiceDetailsInfo> vatInvoiceDetailsInfo = vatInvoiceDetailsInquiry.getVatInvoiceDetailsInquiryRs().getVatInvoiceDetailsList().getVatInvoiceDetailsInfo();
				
				if(GeneralUtil.isListValid(vatInvoiceDetailsInfo)) {
					JRDataSource jrDataSource = new JRBeanCollectionDataSource(vatInvoiceDetailsInfo);
					jasperPrint = JasperFillManager.fillReport(reportInputStream, parameters,jrDataSource);
				}
			}else {
				jasperPrint = JasperFillManager.fillReport(reportInputStream, parameters);
			}
			

			if(ReportFormat.EXCEL.getCode().equalsIgnoreCase(extension)) {
				JRXlsxExporter xlsExporter = new JRXlsxExporter();
				xlsExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
				File outputFile = new File("TransactionDetailsReport.xlsx");
				xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputFile));
				SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
				configuration.setDetectCellType(true);
				configuration.setCollapseRowSpan(false);
				configuration.setAutoFitPageHeight(true);
				xlsExporter.setConfiguration(configuration);
				xlsExporter.exportReport();
				FileInputStream inputStream = new FileInputStream(outputFile);
				report = new String(Base64.getEncoder().encode(IOUtils.toByteArray(inputStream)));
				return report;
			}else if(ReportFormat.WORD.getCode().equalsIgnoreCase(extension)) {
				JRDocxExporter docxExporter = new JRDocxExporter();
				docxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
				SimpleDocxReportConfiguration configuration = new SimpleDocxReportConfiguration();
				File outputFile = new File("TransactionDetailsReport.rtf");
				docxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputFile));
				docxExporter.setConfiguration(configuration);
				docxExporter.exportReport();
				FileInputStream inputStream = new FileInputStream(outputFile);
				report = new String(Base64.getEncoder().encode(IOUtils.toByteArray(inputStream)));
			}else if(ReportFormat.CSV.getCode().equalsIgnoreCase(extension)) {
				JRCsvExporter exporter = new JRCsvExporter();
				exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
				File outputFile = new File("TransactionDetailsReport.csv");
				exporter.setExporterOutput(new SimpleWriterExporterOutput(outputFile));
				SimpleCsvExporterConfiguration configuration = new SimpleCsvExporterConfiguration();
				configuration.setWriteBOM(Boolean.TRUE);
				configuration.setRecordDelimiter("\n");
				configuration.setFieldDelimiter("--");
				configuration.setFieldEnclosure("####");
				exporter.setConfiguration(configuration);
				exporter.exportReport();
				FileInputStream inputStream = new FileInputStream(outputFile);
				report = new String(Base64.getEncoder().encode(IOUtils.toByteArray(inputStream)));
			}else if(ReportFormat.PDF.getCode().equalsIgnoreCase(extension)) {
				JasperExportManager.exportReportToPdfFile(jasperPrint, "Transaction-Details.pdf");
				ByteArrayOutputStream exportedByteStream = new ByteArrayOutputStream();
				JasperExportManager.exportReportToPdfStream(jasperPrint, exportedByteStream);
				report = new String(Base64.getEncoder().encodeToString(exportedByteStream.toByteArray()));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return report;
	}
	
	private Map<String, Object> fillTransactionsParameters(Long accountNumber,
	AccountTransactionInquiryResponseAccountTransactionInquiryResponseTransactionListTransactionInfo transactionInfo,
	VatInvoiceDetailsResponse vatInvoiceDetailsInquiry, String customerName, String customerAddress) {
		Map<String, Object> reportData = new HashMap<>();

		reportData.put("TITLE_AR", getproperty("Ar.TITLE_AR"));
		reportData.put("TITLE_EN", getproperty("En.TITLE_EN"));

		reportData.put("HEADER_LABEL_AR1", getproperty("Ar.HEADER_LABEL_AR1"));
		reportData.put("HEADER_LABEL_EN1", getproperty("En.HEADER_LABEL_EN1"));
		Date transactionDate = Date.from(transactionInfo.getTransactionDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
		reportData.put("HEADER_VALUE1", new SimpleDateFormat("yyyy-MM-dd").format(transactionDate));
		
		reportData.put("HEADER_LABEL_AR2", getproperty("Ar.HEADER_LABEL_AR2"));
		reportData.put("HEADER_LABEL_EN2", getproperty("En.HEADER_LABEL_EN2"));
		reportData.put("HEADER_VALUE2", customerName != null ? customerName : "");
		
		reportData.put("HEADER_LABEL_AR3", getproperty("Ar.HEADER_LABEL_AR3"));
		reportData.put("HEADER_LABEL_EN3", getproperty("En.HEADER_LABEL_EN3"));
		reportData.put("HEADER_VALUE3", customerAddress != null ? customerAddress : "");
		
		reportData.put("LABEL_ONE_AR", getproperty("Ar.LABEL_ONE_AR"));
		reportData.put("LABEL_ONE_EN", getproperty("En.LABEL_ONE_EN"));
		reportData.put("VALUE_ONE", String.valueOf(accountNumber));
		
		reportData.put("LABEL_TWO_AR", getproperty("Ar.LABEL_TWO_AR"));
		reportData.put("LABEL_TWO_EN", getproperty("En.LABEL_TWO_EN"));
		reportData.put("VALUE_TWO", transactionInfo.getTransactionRefNumber());
		
		reportData.put("LABEL_THREE_AR", getproperty("Ar.LABEL_THREE_AR"));
		reportData.put("LABEL_THREE_EN", getproperty("En.LABEL_THREE_EN"));
		String lovRecDescChannel = transactionInfo.getChannelDesc();//getNeededLovByvalue(LOVTypeEnum.CHANNEL.getValue(),transactionInfo.getChannelDesc());
		reportData.put("VALUE_THREE", lovRecDescChannel != null ? lovRecDescChannel : "N/A");
		
		reportData.put("LABEL_FOUR_AR", getproperty("Ar.LABEL_FOUR_AR"));
		reportData.put("LABEL_FOUR_EN", getproperty("En.LABEL_FOUR_EN"));
		String lovRecDescType = transactionInfo.getTransactionCodeDesc();//getNeededLovByvalue(LOVTypeEnum.TRANSACTION_CODE.getValue(),transactionInfo.getTransactionCodeDesc());
		reportData.put("VALUE_FOUR", lovRecDescType != null ? lovRecDescType : "N/A");
		
		reportData.put("LABEL_FIVE_AR", getproperty("Ar.LABEL_FIVE_AR"));
		reportData.put("LABEL_FIVE_EN", getproperty("En.LABEL_FIVE_EN"));
		if(transactionInfo.getDebitAmount() != null)
			reportData.put("VALUE_FIVE", transactionInfo.getDebitAmount().toString());
		else
			reportData.put("VALUE_FIVE", "N/A");
		
		reportData.put("LABEL_SIX_AR", getproperty("Ar.LABEL_SIX_AR"));
		reportData.put("LABEL_SIX_EN", getproperty("En.LABEL_SIX_EN"));
		if(transactionInfo.getCreditAmount() != null)
			reportData.put("VALUE_SIX", transactionInfo.getCreditAmount().toString());
		else
			reportData.put("VALUE_SIX", "N/A");
		
		reportData.put("LABEL_SEVEN_AR", getproperty("Ar.LABEL_SEVEN_AR"));
		reportData.put("LABEL_SEVEN_EN", getproperty("En.LABEL_SEVEN_EN"));
		reportData.put("VALUE_SEVEN", transactionInfo.getDescription() != null ? transactionInfo.getDescription() : "");
		
		reportData.put("LABEL_EIGHT_AR", getproperty("Ar.LABEL_EIGHT_AR"));
		reportData.put("LABEL_EIGHT_EN", getproperty("En.LABEL_EIGHT_EN"));
		reportData.put("VALUE_EIGHT", transactionInfo.getMemo() != null ? transactionInfo.getMemo() : "");

		reportData.put("arabicLabel1", getproperty("Ar.arabicLabel1"));
		reportData.put("englishLabel1", getproperty("En.englishLabel1"));

		reportData.put("arabicLabel2", getproperty("Ar.arabicLabel2"));
		reportData.put("englishLabel2", getproperty("En.englishLabel2"));

		reportData.put("arabicLabel3", getproperty("Ar.arabicLabel3"));
		reportData.put("englishLabel3", getproperty("En.englishLabel3"));

		reportData.put("arabicLabel4", getproperty("Ar.arabicLabel4"));
		reportData.put("englishLabel4", getproperty("En.englishLabel4"));

		reportData.put("arabicLabel5", getproperty("Ar.arabicLabel5"));
		reportData.put("englishLabel5", getproperty("En.englishLabel5"));

		reportData.put("arabicLabel6", getproperty("Ar.arabicLabel6"));
		reportData.put("englishLabel6", getproperty("En.englishLabel6"));
		
		return reportData;
	}

	public String generateReport(String extension, AccountStatementInquiryResponse accountStatementInquiryResponse,Long accountNumber) throws IOException {
		String report = "";
		Map<String, Object> parameters = new HashMap<>();
		JasperReport jasperReport=null;
		JasperPrint jasperPrint =null;
		if(!extension.equalsIgnoreCase("csv"))
		{	
		 jasperReport = loadTemplate();
	 jasperPrint = new JasperPrint();
		}
		parameters = fillparameters(accountStatementInquiryResponse,accountNumber);
		
		TransactionModelDownloadReport transactionModelDownloadReport;
		List<TransactionModelDownloadReport> transactionModelDownloadReportList= new ArrayList<TransactionModelDownloadReport>();
		CombinedDate TransactionDateTime;
		
		for (AccountStatementInquiryResponseStmtDtlsInqRsStatementTransactionListStatementTransactionInfo transaction : accountStatementInquiryResponse
			.getStmtDtlsInqRs().getStatementTransactionList().getStatementTransactionInfo()) {
			Amount amount = new Amount();
			 transactionModelDownloadReport = new TransactionModelDownloadReport();
			TransactionDateTime = new CombinedDate();
			TransactionDateTime.setGregorianDate(Date.from(transaction.getTransDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
			transactionModelDownloadReport.setTransactionDateTime(TransactionDateTime);
//			transactionModelDownloadReport.getTransactionDateTime().setGregorianDate(Date.from(transaction.getTransDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
			transactionModelDownloadReport.setDescription(transaction.getDescription());
			transactionModelDownloadReport.setRunningBalance(transaction.getBalance());
			transactionModelDownloadReport.setTransactionType(TransactionType.getByCode(transaction.getTransType().getCode()));
			
			amount.setAmount(transaction.getAmount().getAmount());
			transactionModelDownloadReport.setAmount(amount);
			
			transactionModelDownloadReportList.add(transactionModelDownloadReport);
			}
		if(extension.equalsIgnoreCase("csv"))
		{	
		try {
			return	inmaReportService.prepareReport(transactionModelDownloadReportList,parameters,ReportFormat.CSV, null, "/reports/detailsCSV.jasper");
		} catch (JRException e) {
			e.printStackTrace();
			logger.error("return Error: " + e.getMessage());
			return null;

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			logger.error("return Error: " + e.getMessage());
			return null;

			} catch (IOException e) {
			e.printStackTrace();
			logger.error("return Error: " + e.getMessage());
		
			return null;
			}
		}else {
		JRDataSource jrDataSource = new JRBeanCollectionDataSource(transactionModelDownloadReportList);
		try {
			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);
		} catch (JRException e1) {
			e1.printStackTrace();
		}
		try {
			if (extension.equalsIgnoreCase("xlsx")) {
				JRXlsxExporter xlsExporter = new JRXlsxExporter();
				xlsExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
				File outputFile = new File("details" + ".EXCEL");
				xlsExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputFile));
				SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
				configuration.setDetectCellType(true);
				configuration.setCollapseRowSpan(false);
				configuration.setAutoFitPageHeight(true);
				xlsExporter.setConfiguration(configuration);
				xlsExporter.exportReport();
				FileInputStream inputStream = new FileInputStream(outputFile);
				 report = new String(Base64.getEncoder().encode(IOUtils.toByteArray(inputStream)));
			} else if (extension.equalsIgnoreCase("docx")) {
				JRDocxExporter docxExporter = new JRDocxExporter();
				SimpleDocxReportConfiguration configuration = new SimpleDocxReportConfiguration();
				docxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
				File outputFile = new File("deatils" + ".docx");
				docxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputFile));
				docxExporter.setConfiguration(configuration);
				docxExporter.exportReport();
				FileInputStream inputStream = new FileInputStream(outputFile);
				report = new String(Base64.getEncoder().encode(IOUtils.toByteArray(inputStream)));
			}
			else
			{
				JasperExportManager.exportReportToPdfFile(jasperPrint, "Details.pdf");
				ByteArrayOutputStream exportedByteStream = new ByteArrayOutputStream();
				JasperExportManager.exportReportToPdfStream(jasperPrint, exportedByteStream);
				report = new String(Base64.getEncoder().encodeToString(exportedByteStream.toByteArray()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("string:"+report);
		return report;}
	}

	private Map<String, Object> fillparameters(AccountStatementInquiryResponse accountStatementInquiryResponse,Long accountNumber) {
		Map<String, Object> reportData = new HashMap<>();

		reportData.put("StatmentTitleAr", getproperty("Ar.Statement.Title"));
		reportData.put("StatmentTitleEn", getproperty("En.Statement.Title"));

		reportData.put("AlinmaIDNumberPromptAr", getproperty("Ar.alinmaId"));
		reportData.put("AlinmaIDNumberPromptEn", getproperty("En.alinmaId"));
		reportData.put("alinmaId", accountStatementInquiryResponse.getStmtDtlsInqRs().getCustomerInfo().getAlinmaId());

		reportData.put("StatmentDateAr", getproperty("Ar.Statement.Date"));
		reportData.put("StatmentDateEn", getproperty("En.Statement.Date"));
		reportData.put("cycleDate", "from " + accountStatementInquiryResponse.getStmtDtlsInqRs().getFromDate() + " to "
		+ accountStatementInquiryResponse.getStmtDtlsInqRs().getToDate());

		reportData.put("CustomerNameAr", getproperty("Ar.Customer.Name.Title"));
		reportData.put("CustomerNameEn", getproperty("En.Customer.Name.Title"));

		reportData.put("AccountNumberAr", getproperty("Ar.accountDetails.label.accountNumber"));
		reportData.put("AccountNumberEn", getproperty("En.accountDetails.label.accountNumber"));

		reportData.put("CurrencyAr", getproperty("Ar.accountDetails.label.accountCurrency"));
		reportData.put("CurrencyEn", getproperty("En.accountDetails.label.accountCurrency"));

		reportData.put("fullName", accountStatementInquiryResponse.getStmtDtlsInqRs().getCustomerInfo().getFullName());

		// check from where
		
		String accountN=accountNumber+"";
		reportData.put("accountNum", accountN);

		reportData.put("accountCurr", accountStatementInquiryResponse.getStmtDtlsInqRs().getAccountCurrency());

		reportData.put("OpenBalanceAr", getproperty("Ar.accountDetails.label.openingBalance"));
		reportData.put("OpenBalanceEn", getproperty("En.accountDetails.label.openingBalance"));
		reportData.put("openingBal", Double.toString(accountStatementInquiryResponse.getStmtDtlsInqRs().getOpeningBalance()));

		reportData.put("CloseBalanceAr", getproperty("Ar.accountDetails.label.closeBalance"));
		reportData.put("CloseBalanceEn", getproperty("En.accountDetails.label.closeBalance"));
		reportData.put("closingBal",Double.toString(accountStatementInquiryResponse.getStmtDtlsInqRs().getClosingBalance()));

		reportData.put("DepositCountAr", getproperty("Ar.accountDetails.label.DepositCount"));
		reportData.put("DepositCountEn", getproperty("En.accountDetails.label.DepositCount"));
		reportData.put("depositCount", accountStatementInquiryResponse.getStmtDtlsInqRs().getNumberOfDeposits());

		reportData.put("DepositTotalAr", getproperty("Ar.accountDetails.label.TotalDeposit"));
		reportData.put("DepositTotalEn", getproperty("En.accountDetails.label.TotalDeposit"));
		reportData.put("totalCreditAmt", Double.toString(accountStatementInquiryResponse.getStmtDtlsInqRs().getTotalCreditAmount()));

		reportData.put("WithdrawCountAr", getproperty("Ar.accountDetails.label.WithdrawCount"));
		reportData.put("WithdrawCountEn", getproperty("En.accountDetails.label.WithdrawCount"));
		reportData.put("withdrawCount", accountStatementInquiryResponse.getStmtDtlsInqRs().getNumberOfWithdraws());

		reportData.put("WithdrawTotalAr", getproperty("Ar.accountDetails.label.TotalWithdraw"));
		reportData.put("WithdrawTotalEn", getproperty("En.accountDetails.label.TotalWithdraw"));
		reportData.put("totalDebitAmt", Double.toString(accountStatementInquiryResponse.getStmtDtlsInqRs().getTotalDebitAmount()));

		reportData.put("FooterMSGAr", getproperty("Ar.Footer.Meg"));
		reportData.put("FooterMSGEn", getproperty("En.Footer.Meg"));

		reportData.put("DateAr", getproperty("Ar.Date"));
		reportData.put("DateEn", getproperty("En.Date"));

		reportData.put("descAr", getproperty("Ar.Date"));
		reportData.put("descEn", getproperty("En.Date"));

		reportData.put("DebitAr", getproperty("Ar.Debit"));
		reportData.put("DebitEn", getproperty("En.Debit"));

		reportData.put("creditAr", getproperty("Ar.Credit"));
		reportData.put("creditEn", getproperty("En.Credit"));

		reportData.put("balanceAr", getproperty("Ar.Balance"));
		reportData.put("balanceEn", getproperty("En.Balance"));

	
		reportData.put("FreePhone", "800 120 8000");
		reportData.put("site", "www.alinma.com");

		return reportData;
	}

	String getproperty(String key) {
		return env.getProperty(key);
	}
	
	private JasperReport loadTemplate() {
		try (InputStream reportInputStream = getClass().getResourceAsStream("/reports/details.jrxml")) {
			final JasperDesign jasperDesign = JRXmlLoader.load(reportInputStream);
			return JasperCompileManager.compileReport(jasperDesign);
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
}