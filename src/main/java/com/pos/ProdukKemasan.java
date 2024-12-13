package com.pos;

public class ProdukKemasan extends Produk {
    private int stok;
    private String merk;
    
    public ProdukKemasan(int id, String nama, double harga, String merk, int stok){
        super(id, nama, harga);
        this.merk = merk;
        this.stok = stok;
    }
    @Override
    public String toString(){
        return super.toString() + ", ProdukKemasan{" + "Stok: " + stok + ", Merk: " + merk + '}'; 
    }
}