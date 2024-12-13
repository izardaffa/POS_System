package com.pos;

public class LaporanHarian extends LaporanPenjualan { 
    // Atribut
    private int totalTransaksi;

    public LaporanHarian(int idLaporan, String tanggal, double totalPenjualan, int totalTransaksi) {
        super(idLaporan, tanggal, totalPenjualan);
        this.totalTransaksi = totalTransaksi;
    }

    @Override
    public void cetakLaporan() {
        System.out.println("Laporan Harian");
    }
}
