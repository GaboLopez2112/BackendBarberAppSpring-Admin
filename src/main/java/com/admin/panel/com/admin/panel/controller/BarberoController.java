package com.admin.panel.com.admin.panel.controller;

import com.admin.panel.com.admin.panel.Dtos.CorteDTO;
import com.admin.panel.com.admin.panel.Dtos.ResumenDiaDTO;
import com.admin.panel.com.admin.panel.Service.CortesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/barberos")
public class BarberoController {
    @Autowired
    private CortesService cortesService;

    @GetMapping("/barberos/{id_barbero}/resumen")
    public ResumenDiaDTO getResumenDelDia(@PathVariable("id_barbero") Long idBarbero) {
        return cortesService.getResumenDelDia(idBarbero);
    }
    @PostMapping("/cortes")
    public ResponseEntity<String> registrarCorte(@RequestBody CorteDTO corteDTO) {
        cortesService.registrarCorte(corteDTO);
        return ResponseEntity.ok("Corte registrado exitosamente");
    }

}
