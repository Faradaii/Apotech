public class Obat{
    public static int jumlahObatKeseluruhan;
    
    public Obat(){
        jumlahObatKeseluruhan++;
        this.setId(jumlahObatKeseluruhan);
    }

    private int id;
    private String namaObat;
    private String kodeObat;
    private int stockObat;
    private String productby;
    private int expiredYear;
    private int harga;

    public int getId(){
        return id;
    }
    private void setId(int id){
        this.id = id;
    }
    public String getNamaObat(){
        return namaObat;
    }
    public void setNamaObat(String namaObat){
        this.namaObat = namaObat;
    }
    public String getKodeObat(){
        return kodeObat;
    }
    public void setKodeObat(String kodeObat){
        this.kodeObat = kodeObat;
    }
    public int getStockObat(){
        return stockObat;
    }
    public void setStockObat(int stockObat){
        this.stockObat = stockObat;
    }
    public String getProductby(){
        return productby;
    }
    public void setProductby(String productby){
        this.productby = productby;
    }
    public int getExpiredYear(){
        return expiredYear;
    }
    public void setExpiredYear(int expiredYear){
        this.expiredYear = expiredYear;
    }
    public int getHarga(){
        return harga;
    }
    public void setHarga(int harga){
        this.harga = harga;
    }


}