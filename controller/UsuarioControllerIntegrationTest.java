@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UsuarioControllerIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testRegistrarUsuario() {
        Usuario usuario = new Usuario("Pedro", "pedro@example.com");

        webTestClient.post().uri("/usuarios/registrar")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(usuario)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$.nombre").isEqualTo("Pedro")
                .jsonPath("$.email").isEqualTo("pedro@example.com");
    }
}
