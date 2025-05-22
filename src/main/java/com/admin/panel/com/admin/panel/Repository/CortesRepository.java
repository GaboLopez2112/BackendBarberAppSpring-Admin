package com.admin.panel.com.admin.panel.Repository;

import com.admin.panel.com.admin.panel.Entity.CortesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CortesRepository extends JpaRepository<CortesEntity, Long> {
    @Query(value = "SELECT COUNT(*), SUM(ganancia_barbero) FROM cortes WHERE id_barbero = :idBarbero AND DATE(fecha) = CURRENT_DATE", nativeQuery = true)
    Object obtenerResumenDelDia(@Param("idBarbero") Long idBarbero);
}
