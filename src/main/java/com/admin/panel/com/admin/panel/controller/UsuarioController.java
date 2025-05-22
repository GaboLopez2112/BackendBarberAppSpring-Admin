package com.admin.panel.com.admin.panel.controller;

import com.admin.panel.com.admin.panel.Entity.UsuarioEntity;
import com.admin.panel.com.admin.panel.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*aaa*/
@Controller
@RequestMapping("/")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/index")
    public String listaUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "index"; // plantilla Thymeleaf: usuarios.html
    }

    @GetMapping("/nuevo")
    public String nuevoFormulario(Model model) {
        model.addAttribute("usuario", new UsuarioEntity());
        return "NuevoUsuario"; // plantilla para crear usuario
    }

    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute UsuarioEntity usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/index";

    }
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
        return "redirect:/index";
    }
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        Optional<UsuarioEntity> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            model.addAttribute("usuario", usuarioOpt.get());
            return "EditarUsuario";
        } else {
            return "redirect:/index";
        }
    }

    @PostMapping("/actualizar")
    public String actualizarUsuario(@ModelAttribute("usuario") UsuarioEntity usuario) {
        usuarioRepository.save(usuario);
        return "redirect:/index";
    }

}
