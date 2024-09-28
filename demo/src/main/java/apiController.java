/*
Este código define un controlador de API REST
usando Spring Boot que maneja solicitudes HTTP.
Tiene una lista de países predefinida, y expone dos endpoints:
uno para obtener la lista completa de países y
otro para obtener un país específico según su índice en la lista.
Si el índice proporcionado en la URL es válido,
devuelve el nombre del país; de lo contrario,
devuelve un mensaje de error indicando que el país no
fue encontrado.*/
package com.example.apirest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*Arriba podemos ver dos cosas, la primera son las bibliotecas que importamos,
u la segunda Este código configura un controlador REST con Spring Boot, asignando
rutas bajo "/api" para manejar solicitudes HTTP y devolver respuestas JSON. */

@RestController /*indica que la clase maneja solicitudes HTTP
y devuelve datos en formato JSON como respuesta, en lugar de una vista.*/

@RequestMapping("/api")/* define la ruta base a partir de la cual se
accederá a los endpoints de la clase, en este caso,
todas las rutas comenzarán con /api.*/

public class apiController {

    private final List<String> paises = new ArrayList<>();

    public apiController() {
        paises.add("Colombia");
        paises.add("Argentina");
        paises.add("Peru");
        paises.add("Chile");
        paises.add("Venezuela");
        paises.add("Ecuador");
        paises.add("Brazil");
        paises.add("Uruguay");
        paises.add("Paraguay");
        paises.add("Bolivia");
    }/*apiController define un controlador que
contiene una lista de países inicializada en el constructor.
Al crear una instancia de esta clase,
se llenará la lista con nombres de países latinoamericanos de la copa.
La lista se declara como final para evitar que su referencia sea cambiada,
pero su relleno puede ser alterado.*/

    @GetMapping("/paises") /*se ejecuta cuando se realiza una solicitud GET a esa URL,*/
    public List<String> getAllCountries() {
        return paises;
    }

    @GetMapping("/paises/{idPais}") /*Este metodo se ejecuta cuando se
realiza una solicitud GET a /api/paises/{idPais},
donde {idPais} es el índice del país que se quiere recuperar de la lista.*/

    public String getCountryById(@PathVariable int idPais) {
        if (idPais >= 0 && idPais < paises.size()) {
            return paises.get(idPais);
        } else {
            return "Pais no encontrado";
        }/* getCountryById usa @PathVariable para capturar el valor de idPais de la URL.
        Verifica si el índice está dentro del rango válido de la lista de países.*/
    }
}
