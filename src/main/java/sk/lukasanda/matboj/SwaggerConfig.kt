package sk.lukasanda.matboj

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
//@Import(SpringDataRestConfiguration.class)
open class SwaggerConfig {
    @Bean
    open fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("Matboj API")
                .description("Matboj app with Spring Boot backend, backed by PostgreSQL.")
                .termsOfServiceUrl("https://www.google.com")
                .contact(Contact(
                        "Lukas Anda",
                        "https://www.google.com",
                        "lukas.anda@gmail.com"))
                .license("Apache License Version 2.0")
                .licenseUrl("https://github.com/garystafford/spring-postgresql-demo/blob/master/LICENSE")
                .version("1.0")
                .build()
    }
}