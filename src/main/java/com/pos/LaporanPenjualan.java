
package com.pos;

public class LaporanPenjualan {
    // Atribut
    private int idLaporan;
    private String tanggal;
    private double totalPenjualan;
    private Pembayaran pembayaran;

    public LaporanPenjualan(int idLaporan, String tanggal, double totalPenjualan, Pembayaran pembayaran) {
        this.idLaporan = idLaporan;
        this.tanggal = tanggal;
        this.totalPenjualan = totalPenjualan;
        this.pembayaran = pembayaran;
    }

    public void updateTotalPenjualan(double amount) {
        this.totalPenjualan += amount;  
    }

    public void cetakLaporan() {
        System.out.println("ID Laporan: " + idLaporan);
        System.out.println("Tanggal: " + tanggal);
        System.out.println("Total Penjualan: " + totalPenjualan);
        // System.out.println("Detail Pembayaran: ");
        // pembayaran.bayar();
    }

    public double getTotalPenjualan() {
        return totalPenjualan;
    }

    public int getIdLaporan() {
        return idLaporan;
    }

    public String getTanggal() {
        return tanggal;
    }
}
