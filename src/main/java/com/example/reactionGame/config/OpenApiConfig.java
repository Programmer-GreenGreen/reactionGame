package com.example.reactionGame.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@SecurityScheme(
        type = SecuritySchemeType.HTTP
)
public class OpenApiConfig {

    /**
     * swagger api 설명.
     */
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info().title("reactionGame Back-end").version("1.0.0")
                .description("반응속도 테스트")
                .termsOfService("http://swagger.io/terms/")
                .contact(new Contact().name("developer-green").url("https://github.com/Programmer-GreenGreen/reactionGame.git").email("fhrrud0334@gmail.com"))
                .license(new License().name("Apache License Version 2.0").url("http://www.apache.org/licenses/LICENSE-2.0"));


        /***
         * @addServersItem : 서버 스키마 설정 가능한 곳
         */
        return new OpenAPI()
                .addServersItem(new Server().url("https://developer-green-final.click:9000"))
                .info(info);
    }

}