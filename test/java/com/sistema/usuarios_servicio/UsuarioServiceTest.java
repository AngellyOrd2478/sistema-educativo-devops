package com.sistema.usuarios_servicio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UsuariosServicioApplicationTests {

	@Test
	void contextLoads() {
	}

}


@RunWith(SpringRunner.class)
@SpringBootTest
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    public void testGuardarUsuario() {
        Usuario usuario = new Usuario("Juan", "juan@example.com");
        Mockito.when(usuarioRepository.save(Mockito.any(Usuario.class))).thenReturn(usuario);

        Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario);
        assertEquals("Juan", usuarioGuardado.getNombre());
    }
}
