package com.admin.panel.com.admin.panel.Service;

import com.admin.panel.com.admin.panel.Dtos.CorteDTO;
import com.admin.panel.com.admin.panel.Dtos.ResumenDiaDTO;
import com.admin.panel.com.admin.panel.Entity.CortesEntity;
import com.admin.panel.com.admin.panel.Entity.UsuarioEntity;
import com.admin.panel.com.admin.panel.Repository.CortesRepository;
import com.admin.panel.com.admin.panel.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Arrays;

@Service
public class CortesService {

    @Autowired
    private CortesRepository cortesRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public ResumenDiaDTO getResumenDelDia(Long idBarbero) {
        Object result = cortesRepository.obtenerResumenDelDia(idBarbero);

        Object[] resultado = (Object[]) result; // Cast correcto
        System.out.println("Resultado: " + Arrays.toString(resultado));

        long cantidad = resultado[0] != null ? ((Number) resultado[0]).longValue() : 0L;
        double sumaGanancias = resultado[1] != null ? ((Number) resultado[1]).doubleValue() : 0.0;

        return new ResumenDiaDTO(cantidad, sumaGanancias);
    }
    public void registrarCorte(CorteDTO dto) {
        CortesEntity corte = new CortesEntity();
        corte.setTipoCorte(dto.tipoCorte);
        corte.setPrecio(dto.precio);
        corte.setFormaPago(dto.formaPago);
        corte.setFotoComprobante(dto.fotoComprobante);


        UsuarioEntity barbero = usuarioRepository.findById(dto.id_barbero)
                .orElseThrow(() -> new RuntimeException("Barbero no encontrado"));

        corte.setBarbero(barbero);

        double ganancia = dto.precio * 0.60;
        corte.setGananciaBarbero(ganancia);

        cortesRepository.save(corte);
    }

}
