package com.pos;

public class PelangganMember extends Pelanggan {
    private double diskon;
    private int point;

    public PelangganMember(int id, String nama, String noHP, int point) {
        super(id, nama, noHP);
        this.point = point;
        // this.diskon = 0.05;
    }

    public double getDiskon() {
        return diskon;
    }

    public int getPoint() {
        return point;
    }

    public void setDiskon() {
        this.diskon = diskon;
    }

    public void setPoint() {
        this.point = point;
    }

    public void tambahPoint(int point) {
        this.point += point;
    }

    public String toString() {
        return super.toString() + " | " + point;
    }
}
