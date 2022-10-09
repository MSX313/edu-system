//package org.msx.software.edu.system.business.util;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.info.BuildProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.*;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.*;
//
//@Configuration
//@EnableSwagger2
//@RequiredArgsConstructor
//public class SwaggerConfig {
//
//    private final BuildProperties buildProperties;
//    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
//            new HashSet<String>(Collections.singletonList("application/json"));
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(getApiInfo())
//                .securityContexts(Arrays.asList(securityContext()))
//                .securitySchemes(Arrays.asList(apiKey()))
//                .select()
//                /*.paths(PathSelectors.ant("/application/*"))*/
//                .apis(RequestHandlerSelectors.basePackage("org.msx.software.edy.system"))
//                .build()
//                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
//                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
//    }
//
//    private Contact getContact() {
//        return new Contact(
//                "Fanap Soft",
//                "https://fanap.ir/fanapsoft",
//                "https://fanap.ir/contact");
//    }
//
//    private ApiInfo getApiInfo() {
//        return new ApiInfo(
//                "Homat REST API",
//                "Homat REST API Documentation",
//                buildProperties.getVersion(),
//                "",
//                getContact(),
//                "",
//                "",
//                Collections.emptyList());
//    }
//
//    private SecurityContext securityContext() {
//        return SecurityContext.builder().securityReferences(defaultAuth()).build();
//    }
//
//    private List<SecurityReference> defaultAuth() {
//        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
//        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
//        authorizationScopes[0] = authorizationScope;
//        return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
//    }
//
//    private ApiKey apiKey() {
//        return new ApiKey("JWT", "Authorization", "header");
//    }
//}