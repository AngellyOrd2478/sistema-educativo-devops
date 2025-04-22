package com.ejemplo.usuarios.controller;

import com.ejemplo.usuarios.model.Usuario;
import com.ejemplo.usuarios.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public Usuario registrar(@RequestBody Usuario usuario) {
        return usuarioService.registrarUsuario(usuario);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credenciales) {
        String token = usuarioService.login(credenciales.get("correo"), credenciales.get("password"));
        return Map.of("token", token);
    }
}




import com.ejemplo.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios/matriculas-asignaturas")  // Endpoint para obtener las matriculas y asignaturas
    public String obtenerMatriculasYAsignaturas() {
        return usuarioService.obtenerMatriculasYAsignaturas();  // Llama al servicio que usa Feign
    }
}





import com.ejemplo.usuarios.security.JwtTokenUtil;
import com.ejemplo.usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;  // Inyecta el JwtTokenUtil para generar tokens

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        // Aquí deberías validar las credenciales del usuario
        // Si son correctas, se genera el token JWT
        String token = jwtTokenUtil.generateToken(username);
        return token;
    }
}
