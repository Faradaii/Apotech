import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Struk {
    private String id;
    private int totalHargaKeseluruhan;
    private String jenisPembayaran;
    private String namaPembeli;
    private ArrayList<String> namaItem = new ArrayList<>();
    private ArrayList<Integer> jumlahItem = new ArrayList<>();
    private ArrayList<Integer> hargaPerItem = new ArrayList<>();

    public void cetak(){
        try {
        FileWriter getFile = new FileWriter("export/struk-"+ this.id +".txt");
        PrintWriter printWriter = new PrintWriter(getFile);  

        printWriter.printf("%-5s %-14s %-17s\n", "", "","Apotech");
        printWriter.printf("%-2s %-45s %-2s\n", "","-------------------------------------------","");
        printWriter.printf("%-5s %-7s %-15s\n", "", "","Struk Pembelian Obat");
        printWriter.printf("%-2s %-45s %-2s\n", "","-------------------------------------------","");
        printWriter.printf("%-5s %-40s %-5s\n", "",getNamaPembeli(),"");
        printWriter.printf("%-2s %-45s %-2s\n", "","-------------------------------------------","");
        printWriter.printf("%-5s %-5s %-15s %-10s %-15s\n", "", "QTY", "Nama Item", "Harga", "Total");
        for(int i = 0 ; i < namaItem.size() ; i++){
            printWriter.printf("%-5s %-5d %-15s %-10s %-15s\n", "", jumlahItem.get(i), namaItem.get(i), hargaPerItem.get(i), hargaPerItem.get(i)*jumlahItem.get(i));

        }
        printWriter.printf("%-2s %-45s %-2s\n", "","-------------------------------------------","");
        printWriter.printf("%-5s %-30s Rp. %-25d\n", "","SubTotal", getTotalHargaKeseluruhan());
        printWriter.printf("%-5s %-30s %-25s\n", "","Jenis Pembayaran", getJenisPembayaran());
        printWriter.printf("%-2s %-45s %-2s\n", "","-------------------------------------------","");
        printWriter.printf("%-5s %-13s %-16s\n", "","","Semoga Lekas Sembuh");
        printWriter.printf("%-2s %-45s %-2s\n", "","-------------------------------------------","");

        printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setKeseluruhan(String id, String namaPembeli, String jenisPembayaran){
        setId(id);
        setNamaPembeli(namaPembeli);
        setJenisPembayaran(jenisPembayaran);
    }

    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }

    public int getTotalHargaKeseluruhan(){
        return this.totalHargaKeseluruhan;
    }
    public void setTotalHargaKeseluruhan(int totalHargaKeseluruhan){
        this.totalHargaKeseluruhan += totalHargaKeseluruhan;
    }

    public String getNamaPembeli(){
        return this.namaPembeli;
    }
    public void setNamaPembeli(String namaPembeli){
        this.namaPembeli = namaPembeli;
    }

    public String getJenisPembayaran(){
        return this.jenisPembayaran;
    }
    public void setJenisPembayaran(String jenisPembayaran){
        this.jenisPembayaran = jenisPembayaran;
    }

    public void tambahPembelian(String namaItem, int jumlahItem, int hargaPerItem){
        this.namaItem.add(namaItem);
        this.jumlahItem.add(jumlahItem);
        this.hargaPerItem.add(hargaPerItem);
        this.totalHargaKeseluruhan += jumlahItem*hargaPerItem;
    }

}
