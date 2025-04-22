package main.java.com.sistema.matriculas_servicio.com.sistema.matriculas.service;

import com.sistema.matriculas.client.UsuarioClient;
import com.sistema.matriculas.client.AsignaturaClient;
import com.sistema.matriculas.model.Matricula;
import com.sistema.matriculas.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {

    private final MatriculaRepository repository;
    private final UsuarioClient usuarioClient;
    private final AsignaturaClient asignaturaClient;

    public MatriculaService(MatriculaRepository repository, UsuarioClient usuarioClient, AsignaturaClient asignaturaClient) {
        this.repository = repository;
        this.usuarioClient = usuarioClient;
        this.asignaturaClient = asignaturaClient;
    }

    public List<Matricula> listar() {
        return repository.findAll();
    }

    public Object registrar(Matricula matricula, String token) {
        Object usuario = usuarioClient.obtenerUsuario(matricula.getUsuarioId(), token);
        Object asignatura = asignaturaClient.obtenerAsignatura(matricula.getAsignaturaId());

        return repository.save(matricula);
    }
}
