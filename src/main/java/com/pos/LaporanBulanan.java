package com.pos;

public class LaporanBulanan extends LaporanPenjualan {
    
    public LaporanBulanan(int idLaporan, String tanggal, double totalPenjualan, Pembayaran pembayaran) {
        super(idLaporan, tanggal, totalPenjualan, pembayaran);
    }

    @Override
    public void cetakLaporan() {
        super.cetakLaporan();
     }
}
