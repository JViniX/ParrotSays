package com.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import static springfox.documentation.builders.PathSelectors.regex;
import com.google.common.collect.Lists;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
// to access to swagger please go to: http://localhost:8167/swagger-ui.html
@Configuration
@EnableSwagger2
@Import(springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

	 public static final String AUTHORIZATION_HEADER = "Authorization";
	    public static final String DEFAULT_INCLUDE_PATTERN = "/api/.*";
	    private final Logger log = LoggerFactory.getLogger(SwaggerConfig.class);

	    @SuppressWarnings("rawtypes")
		@Bean
	    public Docket swaggerSpringfoxDocket() {
	        log.debug("Starting Swagger");
	        Contact contact = new Contact(
	            "Julio Vinicius",
	            "",
	            "");

	        List<VendorExtension> vext = new ArrayList<>();
	        ApiInfo apiInfo = new ApiInfo(
	            "Backend API",
	            "This is the best stuff since sliced bread - API",
	            "1.0.0",
	            "Terms of Services URL",
	            contact,
	            "MIT",
	            "",
	            vext);

	        Docket docket = new Docket(DocumentationType.SWAGGER_2)
	            .apiInfo(apiInfo)
	            .pathMapping("/")
	            .forCodeGeneration(true)
	            .genericModelSubstitutes(ResponseEntity.class)
	            .ignoredParameterTypes(Pageable.class)
	            .ignoredParameterTypes(java.sql.Date.class)
	            .directModelSubstitute(java.time.LocalDate.class, java.sql.Date.class)
	            .directModelSubstitute(java.time.ZonedDateTime.class, Date.class)
	            .directModelSubstitute(java.time.LocalDateTime.class, Date.class)
	            .securityContexts(Lists.newArrayList(securityContext()))
	            .securitySchemes(Lists.newArrayList(apiKey()))
	            .useDefaultResponseMessages(false);

	        docket = docket.select()
	            .paths(regex(DEFAULT_INCLUDE_PATTERN))
	            .build();
	    
	        log.debug("Started Swagger in {} ms");
	        return docket;
	    }


	    private ApiKey apiKey() {
	        return new ApiKey("JWT", AUTHORIZATION_HEADER, "header");
	    }

	    private SecurityContext securityContext() {
	        return SecurityContext.builder()
	            .securityReferences(defaultAuth())
	            .forPaths(PathSelectors.regex(DEFAULT_INCLUDE_PATTERN))
	            .build();
	    }

	    List<SecurityReference> defaultAuth() {
	        AuthorizationScope authorizationScope
	            = new AuthorizationScope("global", "accessEverything");
	        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
	        authorizationScopes[0] = authorizationScope;
	        return Lists.newArrayList(
	            new SecurityReference("JWT", authorizationScopes));
	    }
    
}