
package com.pos;

public class LaporanPenjualan {
    // Atribut
    private int idLaporan;
    private String tanggal;
    private double totalPenjualan;

    public LaporanPenjualan(int idLaporan, String tanggal, double totalPenjualan) {
        this.idLaporan = idLaporan;
        this.tanggal = tanggal;
        this.totalPenjualan = totalPenjualan;
    }

    public void cetakLaporan() {
        System.out.println("ID Laporan: " + idLaporan);
        System.out.println("Tanggal: " + tanggal);
        System.out.println("Total Penjualan: " + totalPenjualan);
    }
}
