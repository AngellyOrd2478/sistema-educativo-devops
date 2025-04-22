package com.sistema.asignaturas_servicio;

import com.sistema.asignaturas.model.Asignatura;
import com.sistema.asignaturas.repository.AsignaturaRepository;
import com.sistema.asignaturas.service.AsignaturaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AsignaturaServiceTest {

    @Test
    public void testObtenerTodasLasAsignaturas() {
        AsignaturaRepository mockRepo = mock(AsignaturaRepository.class);
        AsignaturaService service = new AsignaturaService(mockRepo);

        List<Asignatura> asignaturasFalsas = Arrays.asList(
                new Asignatura("1", "Matemáticas"),
                new Asignatura("2", "Historia")
        );

        when(mockRepo.findAll()).thenReturn(asignaturasFalsas);

        List<Asignatura> resultado = service.getAll();

        assertEquals(2, resultado.size());
        assertEquals("Matemáticas", resultado.get(0).getNombre());
    }
}
