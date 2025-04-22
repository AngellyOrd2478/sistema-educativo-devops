package main.java.com.sistema.asignaturas_servicio.com.sistema.asignaturas.service;

import com.sistema.asignaturas.model.Asignatura;
import com.sistema.asignaturas.repository.AsignaturaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaService {

    private final AsignaturaRepository repository;

    public AsignaturaService(AsignaturaRepository repository) {
        this.repository = repository;
    }

    public List<Asignatura> listar() {
        return repository.findAll();
    }

    public Optional<Asignatura> obtener(Long id) {
        return repository.findById(id);
    }

    public Asignatura crear(Asignatura a) {
        return repository.save(a);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
