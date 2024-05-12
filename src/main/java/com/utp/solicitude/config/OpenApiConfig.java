package com.utp.solicitude.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI(
            @Value("${info.project.title}") String title,
            @Value("${info.project.version}") String version,
            @Value("${info.project.description}") String description,
            @Value("${info.project.server:#{null}}") String server,
            @Value("${info.project.environment:#{null}}") String environment,
            @Value("${server.servlet.context-path}") String context
    ) {
        var openApi = new OpenAPI()
                .info(new Info()
                        .title(title)
                        .version(version)
                        .description(description)
                );

        if (server == null || environment == null || environment.equals("local"))
            return openApi;

        var serverItem = new Server().
                description(title.concat(" ").concat(environment.toUpperCase()));
        var serverWithPath = server.concat(context);

        return openApi.addServersItem(
                serverItem.url(String.format("https://%s", serverWithPath)));
    }

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "springdoc.swagger-ui")
    public SwaggerUiConfigProperties swaggerUiConfig() {
        var properties = new SwaggerUiConfigProperties();

        properties.setDisableSwaggerDefaultUrl(true);

        return properties;
    }
}
