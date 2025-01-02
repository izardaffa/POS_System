package com.pos;

public class Pelanggan {
    private int id;
    private String nama;
    private String noHP;

    public Pelanggan(int id, String nama, String noHP) {
        this.id = id;
        this.nama = nama;
        this.noHP = noHP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

    public String toString() {
        return id + " | " + nama + " | " + noHP;
    }
}
