package com.pos;

public class PelangganPaylater extends Pelanggan {
    private double nominal;
    private double bunga;

    public PelangganPaylater(int id, String nama, String noHP, double nominal) {
        super(id, nama, noHP);
        this.nominal = nominal;
    }

    public double getBunga() {
        return bunga;
    }

    public double getNominal() {
        return nominal;
    }

    public void setBunga() {
        this.bunga = bunga;
    }

    public void setNominal() {
        this.nominal = nominal + (nominal * bunga);
    }

    public String toString() {
        return super.toString() + " | Hutang | Rp. " + nominal;
    }
}
