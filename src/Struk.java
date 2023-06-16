import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Struk {
    private String id;
    private int totalHargaKeseluruhan;
    private String jenisPembayaran;
    private String namaPembeli;
    private String date;
    private int bayar;
    private int beforeDiskon;
    private ArrayList<String> namaItem = new ArrayList<>();
    private ArrayList<Integer> jumlahItem = new ArrayList<>();
    private ArrayList<Integer> hargaPerItem = new ArrayList<>();

    public void cetak(){
        try {
        FileWriter getFile = new FileWriter("export/struk-"+ this.id +".txt");
        PrintWriter printWriter = new PrintWriter(getFile);  

        printWriter.printf("\t\t\t\t\t   %s\n","Apotech");
        printWriter.printf("\t%s\n", "-------------------------------------------------");
        printWriter.printf("\t\t\t\t%s\n", "Struk Pembelian Obat");
        printWriter.printf("\t\t\t\t%5s%s\n"," ", getDate());
        printWriter.printf("\t%s\n", "-------------------------------------------------");
        printWriter.printf("\t\t%-5s\t%-15s %7s\t\t%-8s\n", "QTY","Nama Item","Harga","Total");
        printWriter.printf("\t%s\n", "-------------------------------------------------");
        for(int i = 0 ; i < namaItem.size() ; i++){
            printWriter.printf("\t\t%-5d\t%-15s %7s\t %8s\n", jumlahItem.get(i), namaItem.get(i), hargaPerItem.get(i), hargaPerItem.get(i)*jumlahItem.get(i));

        }        
        printWriter.printf("\t%s\n", "-------------------------------------------------");
        printWriter.printf("\t\t%-30s Rp. %6d\n","Grand Total", getBeforeDiskon());
        printWriter.printf("\t\t%-30s Rp. %6d\n","Total Disc.", getBeforeDiskon()-getTotalHargaKeseluruhan());
        printWriter.printf("\t\t%-30s Rp. %6d\n","Total Belanja", getTotalHargaKeseluruhan());
        printWriter.printf("\t\t%-30s Rp. %6d\n",getJenisPembayaran(), getBayar());
        printWriter.printf("\t\t%-30s Rp. %6d\n","Kembali", getBayar()-getTotalHargaKeseluruhan());
        printWriter.printf("\t%s\n", "-------------------------------------------------");
        if (!this.namaPembeli.equals("anonymous")) {
            printWriter.printf("\t\t%-30s @%10s\n", "member",getNamaPembeli());
        } else {
            printWriter.printf("\t\t%-30s @%10s\n", "member","non-member");
        }
        printWriter.printf("\t%s\n", "-------------------------------------------------");
        printWriter.printf("\t\t\t\t%2s%s\n", " ", "Semoga Lekas Sembuh");
        printWriter.printf("\t%s\n", "-------------------------------------------------");

        printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setKeseluruhan(String id, String namaPembeli, String jenisPembayaran, String date){
        setId(id);
        setNamaPembeli(namaPembeli);
        setJenisPembayaran(jenisPembayaran);
        setDate(date);
    }

    public String getId(){
        return this.id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getDate(){
        return this.date;
    }
    public void setDate(String date){
        this.date = date;
    }

    public int getTotalHargaKeseluruhan(){
        return this.totalHargaKeseluruhan;
    }
    public void setTotalHargaKeseluruhan(int totalHargaKeseluruhan){
        this.totalHargaKeseluruhan += totalHargaKeseluruhan;
    }

    public int getBeforeDiskon(){
        return this.beforeDiskon;
    }
    public void setBeforeDiskon(int beforeDiskon){
        this.beforeDiskon += beforeDiskon;
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

    public void tambahPembelian(String namaItem, int jumlahItem, int hargaBefore, int hargaAfter){
        this.namaItem.add(namaItem);
        this.jumlahItem.add(jumlahItem);
        this.hargaPerItem.add(hargaBefore);
        this.totalHargaKeseluruhan += jumlahItem*hargaAfter;
        this.beforeDiskon += jumlahItem*hargaBefore;
    }
    
    public int getBayar(){
        return this.bayar;
    }
    public void setBayar(int bayar){
        this.bayar = bayar;
    }

}
