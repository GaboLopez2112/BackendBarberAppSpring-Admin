package com.admin.panel.com.admin.panel.Entity;
import jakarta.persistence.*;
@Entity
@Table(name = "pagos_barberos")
public class PagosBarberosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPago;

    @ManyToOne
    @JoinColumn(name = "id_barbero", nullable = false)
    private UsuarioEntity barbero;

    @Column(nullable = false)
    private Integer mes;

    @Column(nullable = false)
    private Integer anio;

    @Column(nullable = false)
    private Double totalAPagar;

    @Column(nullable = false)
    private Boolean pagado = false;

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public UsuarioEntity getBarbero() {
        return barbero;
    }

    public void setBarbero(UsuarioEntity barbero) {
        this.barbero = barbero;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Double getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(Double totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

    public Boolean getPagado() {
        return pagado;
    }

    public void setPagado(Boolean pagado) {
        this.pagado = pagado;
    }
}
