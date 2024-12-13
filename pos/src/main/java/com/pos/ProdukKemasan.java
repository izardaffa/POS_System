public class ProdukKemasan extends Produk {
    private int jumlahKemasan;
    private String merk;
    
    public ProdukKemasan(int id, String nama, double harga, int jumlahKemasan, String merk){
        super(id, nama, harga);
        this.jumlahKemasan = jumlahKemasan;
        this.merk = merk;
    }
    @Override
    public String toString(){
        return super.toString() + ", ProdukKemasan{" + "jumlah kemasan: " + jumlahKemasan + ", Merk: " + merk + '}'; 
    }
}