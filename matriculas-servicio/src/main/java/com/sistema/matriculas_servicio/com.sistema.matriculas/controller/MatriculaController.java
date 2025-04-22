package main.java.com.sistema.matriculas_servicio.com.sistema.matriculas.controller;

import com.sistema.matriculas.model.Matricula;
import com.sistema.matriculas.service.MatriculaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matriculas")
public class MatriculaController {

    private final MatriculaService service;

    public MatriculaController(MatriculaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Matricula> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Matricula matricula, @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(service.registrar(matricula, token));
    }
}
