package com.admin.panel.com.admin.panel.controller;

import com.admin.panel.com.admin.panel.Dtos.ResumenDiaDTO;
import com.admin.panel.com.admin.panel.Entity.UsuarioEntity;
import com.admin.panel.com.admin.panel.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String usuario = loginData.get("usuario");
        String contrasena = loginData.get("contrasena");

        Optional<UsuarioEntity> userOpt = usuarioRepository.findByNombreUsuario(usuario);
        if (userOpt.isPresent() && userOpt.get().getContrasena().equals(contrasena)) {
            UsuarioEntity user = userOpt.get();
            user.setContrasena(null); // No devolvemos la contraseña
            System.out.println("Usuario: " + usuario);
            System.out.println("Contrasena: " + contrasena);
            return ResponseEntity.ok(user);
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
    }


}
