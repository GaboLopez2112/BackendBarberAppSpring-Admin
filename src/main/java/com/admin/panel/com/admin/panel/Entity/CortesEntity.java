package com.admin.panel.com.admin.panel.Entity;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "cortes")
public class CortesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCorte;

    @ManyToOne
    @JoinColumn(name = "id_barbero", nullable = false)
    private UsuarioEntity barbero;

    @Column(nullable = false)
    private String tipoCorte;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private String formaPago;

    @Column(name = "foto_comprobante", length = 10485760)
    private String fotoComprobante; // puede ser URL o base64

    @Column(name = "fecha", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
    private Timestamp fecha;

    @Column(nullable = false)
    private Double gananciaBarbero;

    public Double getGananciaBarbero() {
        return gananciaBarbero;
    }

    public void setGananciaBarbero(Double gananciaBarbero) {
        this.gananciaBarbero = gananciaBarbero;
    }

    public Long getIdCorte() {
        return idCorte;
    }

    public void setIdCorte(Long idCorte) {
        this.idCorte = idCorte;
    }

    public UsuarioEntity getBarbero() {
        return barbero;
    }

    public void setBarbero(UsuarioEntity barbero) {
        this.barbero = barbero;
    }

    public String getTipoCorte() {
        return tipoCorte;
    }

    public void setTipoCorte(String tipoCorte) {
        this.tipoCorte = tipoCorte;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getFotoComprobante() {
        return fotoComprobante;
    }

    public void setFotoComprobante(String fotoComprobante) {
        this.fotoComprobante = fotoComprobante;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}
