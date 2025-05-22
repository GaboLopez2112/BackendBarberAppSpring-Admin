package com.admin.panel.com.admin.panel.Dtos;

public class ResumenDiaDTO {
    private long cortes;
    private double ingresos ;
    public ResumenDiaDTO(Long cortes, Double ingresos) {
        this.cortes = cortes;
        this.ingresos = ingresos;
    }

    public long getCortes() {
        return cortes;
    }

    public void setCortes(int cortes) {
        this.cortes = cortes;
    }

    public double getIngresos() {
        return ingresos;
    }

    public void setIngresos(double ingresos) {
        this.ingresos = ingresos;
    }
}
