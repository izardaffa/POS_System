package com.pos;

abstract class Pembayaran {
    protected int idPembayaran;
    protected int tanggal;
    protected double totalPembayaran;

    public Pembayaran(int idPembayaran, int tanggal, double totalPembayaran) {
        this.idPembayaran = idPembayaran;
        this.tanggal = tanggal;
        this.totalPembayaran = totalPembayaran;
    }

    public abstract void bayar();
}
