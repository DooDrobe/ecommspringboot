
package com.appdev.app.configuration;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Springboot + REST + JPA + Jackson API")
                        .description("Inventory management and PG API")
                        .version("1.0")
                        .contact(new Contact()
                                .name("DooDrobe")
                                .url("www.linkedin.com/in/hatta-farhan-hasyim/")
                                .email("hatta616@gmail.com")
                        )
                );
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/rest/**")
                .packagesToScan("com.appdev.app")
                .build();
    }
}
//@Configuration
//public class SwaggerConfiguration {
//
//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI()
//                .info(new Info()
//                        .title("Spring Boot API")
//                        .version("1.0")
//                        .description("Description of the API")
//                );
//    }
//}
