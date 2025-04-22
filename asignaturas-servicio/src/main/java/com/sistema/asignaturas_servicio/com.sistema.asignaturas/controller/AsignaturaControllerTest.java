package com.sistema.asignaturas_servicio;

import com.sistema.asignaturas.controller.AsignaturaController;
import com.sistema.asignaturas.model.Asignatura;
import com.sistema.asignaturas.service.AsignaturaService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AsignaturaControllerTest {

    @Test
    public void testListarAsignaturas() {
        AsignaturaService serviceMock = mock(AsignaturaService.class);
        AsignaturaController controller = new AsignaturaController(serviceMock);

        List<Asignatura> asignaturas = Arrays.asList(
                new Asignatura("1", "Lengua"),
                new Asignatura("2", "Ciencias")
        );

        when(serviceMock.getAll()).thenReturn(asignaturas);

        ResponseEntity<List<Asignatura>> respuesta = controller.listar();

        assertEquals(200, respuesta.getStatusCodeValue());
        assertEquals(2, respuesta.getBody().size());
    }
}
