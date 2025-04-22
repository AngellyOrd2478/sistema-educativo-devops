package com.sistema.asignaturas_servicio;

import com.sistema.asignaturas.model.Asignatura;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AsignaturaIntegrationTest {

    @LocalServerPort
    private int port;

    @Test
    public void testEndpointListarAsignaturas() {
        WebTestClient client = WebTestClient.bindToServer()
                .baseUrl("http://localhost:" + port)
                .build();

        client.get().uri("/asignaturas")
                .exchange()
                .expectStatus().isOk();
    }
}
