package com.usa.nj.gov.ed.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This Class is used to Add Swagger COnfiguration for Rest API
 * 
 * @author hp
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
 public SwaggerConfig() {
	 System.out.println("SwaggerConfig::::0 Param Constructor SwaggerConfig()");
 }
	@Bean
	public Docket ssaWebApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.usa.nj.gov.ed.controller")).paths(PathSelectors.any())
				.build().apiInfo(metaData());
	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("EDRules REST API", "EDRules Rest API For USA New Jersey Gov.", "1.0",
				"Terms of service", new Contact("John Thompson", "https://www.usa.nj.gov/", "john@usa.gov"),
				"Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0");
		return apiInfo;
	}

}
