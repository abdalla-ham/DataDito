package com.datadito.aom.configuration;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * OpenAPI configuration class for datadito project
 * Contains information about the project
 * It can be reached from the /swagger-ui.html endpoint
 */
@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "datadito",
                        url = "https://github.com/abdalla-ham/DataDito/tree/main"
                ),
                description = "OpenAPI documentation for datadito project",
                title = "OpenAPI Specification - datadito",
                version = "1.0"
        )
)
public class OpenApiConfiguration { }