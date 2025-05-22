package com.admin.panel.com.admin.panel.Repository;

import com.admin.panel.com.admin.panel.Entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByNombreUsuario(String nombreUsuario);
}
