public class Obat{
    public static int jumlahObatKeseluruhan;
    
    public Obat(){
        jumlahObatKeseluruhan++;
    }

    private int id;
    private String namaObat;
    private String kodeObat;
    private String untukPenyakit;
    private String productby;
    private int expiredYear;

    public int getId(){
        return id;
    }
    public void setId(int id){
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
    public String getUntukPenyakit(){
        return untukPenyakit;
    }
    public void setUntukPenyakit(String untukPenyakit){
        this.untukPenyakit = untukPenyakit;
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
    public void setProductby(int expiredYear){
        this.expiredYear = expiredYear;
    }


}