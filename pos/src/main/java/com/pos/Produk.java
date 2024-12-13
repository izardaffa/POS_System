public class Produk {
    private int id;
    private String nama;
    private double harga;
    
    public Produk(int id, String nama, double harga){
        this.id = id;
        this.nama = nama;
        this.harga = harga;
    }
    public int getId(){
        return id;
    }
    public String getNama(){
        return nama;
    }
    public double getHarga(){
        return harga;
    }
    @Override
    public String toString(){
        return "Produk{" + "id :" + id + ", nama:" + nama + ", harga: " + harga + ")";
    }
}