import java.time.LocalDate;
public class RestockObat extends Laporan{
    
    private String supplier;
    private int harga;
    private String kodeObat;
    private int stockObat;
    Obat obat = new Obat();

    public RestockObat(){
        idLaporan++;
        this.setId();
        this.setDate();
    }
    
    public String getId() {
        return id;
    }
    public void setId() {
        this.id = "Z0"+ idLaporan;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getKodeObat() {
        return kodeObat;
    } 
    public void setKodeObat(String kodeObat){
        this.kodeObat = kodeObat;
        obat.setKodeObat(this.kodeObat);
    }
    public String getNamaObat(){
        return namaObat;
    }
    public void setNamaObat(String namaObat){
        this.namaObat = namaObat;
        obat.setNamaObat(this.namaObat);
    }
    public String getSupplier(){
        return supplier;
    }
    public void setSupplier(String supplier){
        this.supplier = supplier;
    }
    public LocalDate getDate(){
        return this.date;
    }
    public void setDate(){
        this.date = super.generateDate();
    }
    //overloading
    public void setDate(LocalDate date){
        this.date = date;
    }
    public int getStockObat(){
        return stockObat;
    }
    public void setStockObat(int stockObat){
        this.stockObat = stockObat;
        obat.setStockObat(this.stockObat);
    }
    public int getTotalHarga(){
        return totalHarga;
    }
    public void setTotalHarga(int totalHarga){
        this.totalHarga = totalHarga;
    }
    public void setHarga(int harga){
        this.harga = harga;
        obat.setHarga(this.harga*12/10);
    }
    public int getHarga(){
        return this.harga;
    }

}
