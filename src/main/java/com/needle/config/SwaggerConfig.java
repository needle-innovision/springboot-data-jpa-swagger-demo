package com.needle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger configuration for the spring boot data rest is given here
 * 
 * @author sandeepknair
 *
 */
@Configuration
@EnableSwagger2
// Configuration for swagger to pick up the jpa repositories
@Import({ springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class,
		springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class })
public class SwaggerConfig {
	/**
	 * Swagger configuration
	 * 
	 * @return
	 */
	@Bean
	public Docket swaggerSettings() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().pathMapping("/").apiInfo(apiInfo());
	}

	/**
	 * For generating the api information
	 * 
	 * @return
	 */
	private ApiInfo apiInfo() {
		@SuppressWarnings("deprecation")
		ApiInfo apiInfo = new ApiInfo("Swagger Testing", "Simple api to test swagger on spring data rest", "0.0.1",
				"Terms of service", "sandeep@needleinnovision.com", "License of API", "API license URL");
		return apiInfo;
	}
}
