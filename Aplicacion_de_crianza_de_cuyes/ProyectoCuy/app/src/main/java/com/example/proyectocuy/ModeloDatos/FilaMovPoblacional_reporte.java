package com.example.proyectocuy.ModeloDatos;

public class FilaMovPoblacional_reporte {
    private String tipoMovimiento;
    private int lc_hembras, lc_machos, rc_hembras, rc_machos, eg_hembras, eg_machos, padrillos, madres;

    public FilaMovPoblacional_reporte(String tipoMovimiento, int lc_hembras, int lc_machos, int rc_hembras, int rc_machos, int eg_hembras, int eg_machos, int padrillos, int madres) {
        this.tipoMovimiento = tipoMovimiento;
        this.lc_hembras = lc_hembras;
        this.lc_machos = lc_machos;
        this.rc_hembras = rc_hembras;
        this.rc_machos = rc_machos;
        this.eg_hembras = eg_hembras;
        this.eg_machos = eg_machos;
        this.padrillos = padrillos;
        this.madres = madres;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public int getLc_hembras() {
        return lc_hembras;
    }

    public void setLc_hembras(int lc_hembras) {
        this.lc_hembras = lc_hembras;
    }

    public int getLc_machos() {
        return lc_machos;
    }

    public void setLc_machos(int lc_machos) {
        this.lc_machos = lc_machos;
    }

    public int getRc_hembras() {
        return rc_hembras;
    }

    public void setRc_hembras(int rc_hembras) {
        this.rc_hembras = rc_hembras;
    }

    public int getRc_machos() {
        return rc_machos;
    }

    public void setRc_machos(int rc_machos) {
        this.rc_machos = rc_machos;
    }

    public int getEg_hembras() {
        return eg_hembras;
    }

    public void setEg_hembras(int eg_hembras) {
        this.eg_hembras = eg_hembras;
    }

    public int getEg_machos() {
        return eg_machos;
    }

    public void setEg_machos(int eg_machos) {
        this.eg_machos = eg_machos;
    }

    public int getPadrillos() {
        return padrillos;
    }

    public void setPadrillos(int padrillos) {
        this.padrillos = padrillos;
    }

    public int getMadres() {
        return madres;
    }

    public void setMadres(int madres) {
        this.madres = madres;
    }
}
