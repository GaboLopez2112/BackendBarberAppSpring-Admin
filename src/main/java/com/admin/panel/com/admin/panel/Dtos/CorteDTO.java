package com.admin.panel.com.admin.panel.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CorteDTO {
    public String tipoCorte;
    public Double precio;
    public String formaPago;
    public String fotoComprobante;
    @JsonProperty("idBarbero")
    public Long id_barbero;
}
