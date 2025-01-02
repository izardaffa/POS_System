package com.pos;

public class ProdukEceran extends Produk {
    private String satuan;
    private int stok;
    
    public ProdukEceran(int id, String nama, double harga, String satuan, int stok){
        super(id, nama, harga);
        this.satuan = satuan;
        this.stok = stok;
    }

    public String getSatuan(){
        return satuan;
    }

    public int getStok(){
        return stok;
    }

    public void setSatuan(String satuan){
        this.satuan = satuan;
    }

    public void setStok(int stok){
        this.stok = stok;
    }

    @Override
    public String toString(){
        return super.toString() + ", ProdukEceran{" + "satuan: " + satuan + ", stok: " + stok + '}';
    }
}