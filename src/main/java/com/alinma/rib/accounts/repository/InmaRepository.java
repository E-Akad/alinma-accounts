//package com.alinma.rib.accounts.repository;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Types;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.core.SqlOutParameter;
//import org.springframework.jdbc.core.SqlParameter;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.jdbc.core.simple.SimpleJdbcCall;
//import org.springframework.stereotype.Repository;
//
//import com.alinma.rib.accounts.model.CardFeeFieldDialog;
//
//import oracle.jdbc.OracleTypes;
//
//@Repository
//public class InmaRepository {
//
//	@Autowired
//	private JdbcTemplate jdbcTemplate;
//	
//	public Map<String, Object> findCardsChargesAndFeesForDialog(String cardType) {
//		RowMapper<CardFeeFieldDialog> mapper = new RowMapper<CardFeeFieldDialog>() {
//			public CardFeeFieldDialog mapRow(ResultSet rs, int rowNum) throws SQLException { 
//				String labelArabic = rs.getString("LABEL_ARABIC");
//				String labelEnglish = rs.getString("LABEL_ENGLISH");
//				String valueArabic = rs.getString("VALUE_ARABIC");
//				String valueEnglish = rs.getString("VALUE_ENGLISH");
//				int orderFee = Integer.parseInt(rs.getString("ORDER_FEE"));
//				CardFeeFieldDialog cardFeeFieldDialog = new CardFeeFieldDialog();
//				cardFeeFieldDialog.setLabelArabic(labelArabic);
//				cardFeeFieldDialog.setLabelEnglish(labelEnglish);
//				cardFeeFieldDialog.setValueArabic(valueArabic);
//				cardFeeFieldDialog.setValueEnglish(valueEnglish);
//				cardFeeFieldDialog.setOrderFee(orderFee);
//				
//				return cardFeeFieldDialog;
//			}
//		};
//		
//		MapSqlParameterSource in = new MapSqlParameterSource();
//		
//		in.addValue("p_CARD_TYPE", cardType);
//
//		SimpleJdbcCall getKey = new SimpleJdbcCall(jdbcTemplate)
//				.withProcedureName("GET_CARDS_FEES_WITH_CARD_TYPE")
//				.withoutProcedureColumnMetaDataAccess()
//				.returningResultSet("p_RESULT", mapper)
//				.declareParameters(
//								new SqlParameter("p_CARD_TYPE", Types.VARCHAR),
//								new SqlOutParameter("p_ERROR_CODE", Types.VARCHAR),
//								new SqlOutParameter("p_RESULT", OracleTypes.CURSOR));
//		
//		Map<String, Object> outParameter = 	getKey.execute(in);
//		
//		return outParameter;
//	}
//	
//	
//}
