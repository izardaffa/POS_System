package com.pos;

import java.util.Scanner;

class PembayaranCash extends Pembayaran {
    private double uangDiterima;
    private double kembalian;

    public PembayaranCash(int idPembayaran, int tanggal, double totalPembayaran) {
        super(idPembayaran, tanggal, totalPembayaran);
    }

    @Override
    public void bayar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah uang yang diterima: ");
        uangDiterima = scanner.nextDouble();

        if (uangDiterima >= totalPembayaran) {
            kembalian = uangDiterima - totalPembayaran;
            System.out.println("Pembayaran berhasil. Kembalian: " + kembalian);
        } else {
            System.out.println("Uang tidak cukup untuk membayar.");
        }
    }
}