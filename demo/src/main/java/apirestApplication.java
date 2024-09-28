package com.example.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class apirestApplication {

    public static void main(String[] args) {
        SpringApplication.run(apirestApplication.class, args);
    }
}
/*La clase apirestApplication es la clase principal de una aplicación Spring Boot.
La anotación @SpringBootApplication marca esta clase como la configuración principal y
activa la auto-configuración y el escaneo de componentes. El metodo main
 ejecuta la aplicación, iniciando el contexto de Spring Boot y lanzando el servidor.*/
