package com.pos;

public class ProdukKemasan extends Produk {
    private int jumlahKemasan;
    private String merk;
    private int stok;
    
    public ProdukKemasan(int id, String nama, double harga, int jumlahKemasan, String merk, int stok){
        super(id, nama, harga);
        this.jumlahKemasan = jumlahKemasan;
        this.merk = merk;
    }
    @Override
    public String toString(){
        return super.toString() + ", ProdukKemasan{" + "jumlah kemasan: " + jumlahKemasan + ", Merk: " + merk + '}'; 
    }
}