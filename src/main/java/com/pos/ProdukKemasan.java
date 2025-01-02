package com.pos;

public class ProdukKemasan extends Produk {
    private int stok;
    private String merk;
    
    public ProdukKemasan(int id, String nama, double harga, String merk, int stok){
        super(id, nama, harga);
        this.merk = merk;
        this.stok = stok;
    }

    public String getMerk(){
        return merk;
    }

    public int getStok(){
        return stok;
    }

    public void setMerk(String merk){
        this.merk = merk;
    }

    public void setStok(int stok){
        this.stok = stok;
    }

    @Override
    public String toString(){
        return super.toString() + ", ProdukKemasan{" + "Stok: " + stok + ", Merk: " + merk + '}'; 
    }
}