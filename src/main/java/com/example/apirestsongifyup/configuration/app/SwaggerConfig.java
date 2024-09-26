package com.example.apirestsongifyup.configuration.app;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "API MUSIC",
                description = "La aplicacion administra el registro de canciones del ususario",
                termsOfService = "www.emanuelreyes-portfolio.netlify.app/terminos_y_condiciones",
                version = "1.0.0",
                contact = @Contact(
                        name = "Emanuel Reyes",
                        url = "www.emanuelreyes-portfolio.netlify.app",
                        email = "EmanuelRFdev@gmial.com"
                ),
                license = @License(
                        name = "Standard Software Use License for Emanuel Reyes",
                        url = "www.emanuelreyes-portfolio.netlify.app/licence"
                )
        ),
        servers = {
                @Server(
                        description = "TEST SERVER",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "PROD SERVER",
                        url = "http://localhost:8080"
                )
        }
)
public class SwaggerConfig {}
