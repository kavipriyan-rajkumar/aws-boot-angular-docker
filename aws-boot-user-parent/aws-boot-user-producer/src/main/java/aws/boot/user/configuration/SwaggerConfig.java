package aws.boot.user.configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Data @AllArgsConstructor @NoArgsConstructor

@Configuration @EnableSwagger2
@ConfigurationProperties("swagger.app.api")
@ConditionalOnProperty(name="swagger.app.api.enable", havingValue = "true", matchIfMissing = false)
public class SwaggerConfig {
	private String version;
	private String title;
	private String description;
	private String basePackage;
	private String contactName;
	private String contactEmail;
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage(basePackage))
			.paths(PathSelectors.any())
			.build()
			.directModelSubstitute(LocalDate.class, java.sql.Date.class)
			.directModelSubstitute(LocalDateTime.class, java.util.Date.class)
			.apiInfo(apiInfo());
	}
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
			.title(title)
			.description(description)
			.version(version)
			.build();
	}

	/** 
	@Bean
	public Docket swaggerApiDocket() {
		// Docket is a builder which is intended to be the primary interface into the swagger-springmvc framework
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		// which provides control over the endpoints exposed by Swagger.
		ApiSelectorBuilder apiSelectorBuilder = docket.select();
		// create APIs for basePackage's all classes
		apiSelectorBuilder = apiSelectorBuilder.apis(RequestHandlerSelectors.basePackage(basePackage));
		// apiSelectorBuilder.paths(regex("/v1.*"));
		// defines for which paths in our APIs do we want to create documentation for. ex: our case @RequestMapping("/api")
		apiSelectorBuilder.paths(PathSelectors.any()); // include all endpoints 
		docket = apiSelectorBuilder.build();
		
		docket.directModelSubstitute(LocalDate.class, java.sql.Date.class);
		docket.directModelSubstitute(LocalDateTime.class, java.util.Date.class);
		docket.apiInfo(swaggerAPIInformation());
		return docket;
	}
	
	private ApiInfo swaggerAPIInformation() {
		ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();
		apiInfoBuilder.title(title);
		apiInfoBuilder.version(version);
		apiInfoBuilder.description(description);
		
		ApiInfo apiInfo = apiInfoBuilder.build();
		return apiInfo;
	}
	**/
}
