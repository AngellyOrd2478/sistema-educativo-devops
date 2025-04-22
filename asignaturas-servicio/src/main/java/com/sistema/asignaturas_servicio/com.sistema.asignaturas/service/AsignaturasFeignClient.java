package com.ejemplo.usuarios.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "asignaturas-servicio", url = "http://localhost:8083")  // Cambia la URL según el puerto
public interface AsignaturasFeignClient {

    @GetMapping("/asignaturas")
    String obtenerAsignaturas();
}
