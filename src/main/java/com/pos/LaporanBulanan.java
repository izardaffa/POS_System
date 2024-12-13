package com.pos;

public class LaporanBulanan extends LaporanPenjualan {
    // Atribut
    private String bulan;
    private int tahun;

    public LaporanBulanan(int idLaporan, String tanggal, double totalPenjualan, String bulan, int tahun) {
        super(idLaporan, tanggal, totalPenjualan);
        this.bulan = bulan;
        this.tahun = tahun;
    }

    @Override
    public void cetakLaporan() {
        System.out.println("Laporan Bulanan");
    }
}