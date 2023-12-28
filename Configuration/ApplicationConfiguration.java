//package springBoot_CollageProject.Configuration;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.service.VendorExtension;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class ApplicationConfiguration {
//
//	@Bean
//	public Docket getDocket() {
//		Contact contact = new Contact("Collage-App", "www.collage.com", "www.EduTechcollages@gmail.com");
//		List<VendorExtension> vendorExtension = new ArrayList<>();
//
//		ApiInfo apiInfo = new ApiInfo("CollageApp", "collage application for offline classes", "1.02", "www.EduTechcollages.com", contact,
//				"1 year and 2nd year", "www.EduTechcollages.com", vendorExtension);
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.apis(RequestHandlerSelectors.basePackage("/springBoot_CollageProject")).build()
//				.apiInfo(apiInfo).useDefaultResponseMessages(false);
//	}
//	
//}
