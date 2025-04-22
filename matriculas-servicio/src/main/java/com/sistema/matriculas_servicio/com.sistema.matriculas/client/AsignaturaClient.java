package main.java.com.sistema.matriculas_servicio.com.sistema.matriculas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "asignaturas-servicio", url = "http://localhost:8082")
public interface AsignaturaClient {
    @GetMapping("/api/asignaturas/{id}")
    Object obtenerAsignatura(@PathVariable Long id);
}

