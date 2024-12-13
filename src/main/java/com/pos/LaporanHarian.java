package com.pos;

public class LaporanHarian extends LaporanPenjualan { 
    // Atribut
    private int totalTransaksi;

    public LaporanHarian(int idLaporan, String tanggal, double totalPenjualan, Pembayaran pembayaran, int totalTransaksi) {
        super(idLaporan, tanggal, totalPenjualan, pembayaran);
        this.totalTransaksi = totalTransaksi;
    }

    @Override
    public void cetakLaporan() {
        super.cetakLaporan();
        System.out.println("Total Transaksi: " + totalTransaksi);
    }
}
