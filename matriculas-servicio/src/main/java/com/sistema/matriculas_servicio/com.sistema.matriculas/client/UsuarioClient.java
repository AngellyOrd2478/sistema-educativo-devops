package main.java.com.sistema.matriculas_servicio.com.sistema.matriculas.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuarios-servicio", url = "http://localhost:8081")
public interface UsuarioClient {
    @GetMapping("/api/usuarios/{id}")
    Object obtenerUsuario(@PathVariable Long id, @RequestHeader("Authorization") String token);
}
