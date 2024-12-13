public class ProdukEceran extends Produk {
    private String satuan;
    private int stok;
    
    public ProdukEceran(int id, String nama, double harga, String satuan, int stok){
        super(id, nama, harga);
        this.satuan = satuan;
        this.stok = stok;
    }
    @Override
    public String toString(){
        return super.toString() + ", ProdukEceran{" + "satuan: " + satuan + ", stok: " + stok + '}';
    }
}