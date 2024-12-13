package com.pos;

public class PelangganPaylater extends Pelanggan {
    private double bunga;

    public PelangganPaylater(int id, String nama, String noHP) {
        super(id, nama, noHP);
        this.bunga = 0.1;
    }

    public double getBunga() {
        return bunga;
    }

    public void setBunga() {
        this.bunga = bunga;
    }

    public String toString() {
        return super.toString() + " | Hutang";
    }
}
