public class Membership{
    public static int jumlahMembershipsKeseluruhan;
    private int id;

    public Membership(){
        jumlahMembershipsKeseluruhan++;
        id++;
    }

    private String nama;
    private String alamat;
    private String jenisKelamin;
    private String nomorTelpon;
    private String umur;

    public int getId() {
        return id;
    }
    //method berikut digunakan jika apotek sudah memiliki member. dan untuk mengetahui informasi tersebut diperlukan pembacaan databse.
    public void setId(int id){
        this.id = id;
    }

    public String getNama(){
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public String getAlamat(){
        return alamat;
    }
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    public String getJenisKelamin(){
        return jenisKelamin;
    }
    public void setJenisKelamin(String jenisKelamin){
        this.jenisKelamin = jenisKelamin;
    }
    public String getNomorTelpon(){
        return nomorTelpon;
    }
    public void setNomorTelpon(String nomorTelpon){
        this.nomorTelpon = nomorTelpon;
    }
    public String getUmur(){
        return umur;
    }
    public void setUmur(String umur){
        this.umur = umur;
    }

}