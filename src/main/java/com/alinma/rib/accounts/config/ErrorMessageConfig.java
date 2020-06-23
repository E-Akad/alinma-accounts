/**
 * 
 */
package com.alinma.rib.accounts.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author Omnya Alaa
 * @since 30-12-2019
 *
 */
@Configuration
public class ErrorMessageConfig {

	@Bean(name = "customErrorMsg")
	public MessageSource customErrorMessages() {
		ResourceBundleMessageSource messageBundleResrc = new ResourceBundleMessageSource();
		messageBundleResrc.setBasename("CustomErrorMessages");
		return messageBundleResrc;
	}
}
