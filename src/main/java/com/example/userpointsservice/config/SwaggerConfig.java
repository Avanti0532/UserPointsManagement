package com.example.userpointsservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder()
				.title("User Points Management API")
				.description("This Api is used to add/update/get user points")
				.version("1.0.0")
				.license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\\\"")
				.build();
	}
	
	@Bean
	public Docket getApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.userpointsservice"))
				.build()
				.apiInfo(getApiInfo())
				.useDefaultResponseMessages(false);

	}
}
