package com.pos;

import java.util.*;

class PembayaranQris extends Pembayaran {
    private String kodeQR;
    private String namaBank;

    public PembayaranQris(int idPembayaran, int tanggal, double totalPembayaran, String namaBank) {
        super(idPembayaran, tanggal, totalPembayaran);
        this.namaBank = namaBank;
        this.kodeQR = generateKodeQR();
    }

    private String generateKodeQR() {
        return "QR" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    @Override
    public void bayar() {
        System.out.println("Pembayaran berhasil menggunakan QRIS.");
        System.out.println("Kode QR: " + kodeQR);
        System.out.println("Nama Bank: " + namaBank);
    }
}