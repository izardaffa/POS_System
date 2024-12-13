package com.pos;

public class PelangganMember extends Pelanggan {
    private double diskon;

    public PelangganMember(int id, String nama, String noHP) {
        super(id, nama, noHP);
        this.diskon = 0.05;
    }

    public double getDiskon() {
        return diskon;
    }

    public void setDiskon() {
        this.diskon = diskon;
    }

    public String toString() {
        return super.toString() + " | Member";
    }
}
