package com.ejemplo.usuarios.service;

import com.ejemplo.usuarios.model.Usuario;
import com.ejemplo.usuarios.repository.UsuarioRepository;
import com.ejemplo.usuarios.security.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, JwtUtil jwtUtil) {
        this.usuarioRepository = usuarioRepository;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return usuarioRepository.save(usuario);
    }

    public String login(String correo, String password) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByCorreo(correo);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            if (passwordEncoder.matches(password, usuario.getPassword())) {
                return jwtUtil.generateToken(usuario.getCorreo(), usuario.getRol());
            }
        }
        throw new RuntimeException("Credenciales inválidas");
    }
}





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private MatriculasFeignClient matriculasFeignClient;  // Inyecta el Feign Client para el servicio de matriculas

    @Autowired
    private AsignaturasFeignClient asignaturasFeignClient;  // Inyecta el Feign Client para el servicio de asignaturas

    // Método que usa los Feign Clients para obtener datos de los otros microservicios
    public String obtenerMatriculasYAsignaturas() {
        String matriculas = matriculasFeignClient.obtenerMatriculas();  // Llama al servicio de matriculas
        String asignaturas = asignaturasFeignClient.obtenerAsignaturas();  // Llama al servicio de asignaturas
        return "Matriculas: " + matriculas + ", Asignaturas: " + asignaturas;  // Devuelve la respuesta combinada
    }
}
