package com.ejemplo.usuarios.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "matriculas-servicio", url = "http://localhost:8082")  // Cambia la URL según el puerto de tu microservicio
public interface MatriculasFeignClient {

    @GetMapping("/matriculas")
    String obtenerMatriculas();
}
