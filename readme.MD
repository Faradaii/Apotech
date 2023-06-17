
## Apotech
Aplikasi manajemen Inventaris Apotek: Aplikasi yang membantu apoteker untuk menginventaris obat, pemesanan pembelian, pelepasan penjualan serta keuntungan. Ringkasan class :
    - Main
    - Apotek
    - Obat
    - Membership (bisa mendapat diskon sebesar 2%)
    - Laporan (penjualan obat, restock obat)
    - Saldo
    - Struk

## Presentasi Project PBO UAS

Materi: 
1. Class & Object
2. Constructor
3. Access Modifier
4. Encapsulation
5. Inheritance
6. Polimorfisme
7. Abstraction
8. ArrayList

Penilaian: 
1. Penguasaan Konsep 4 Pilar OOP: 80%
2. Penguasaan Keseluruhan Source Code: 20%

## Menu
Sebelum masuk ke menu, system harus meload data dari database terlebih dahulu

    1. Kasir
        a. Pembelian obat oleh pelanggan
        b. Pembuatan member baru
    2. Manajemen Obat
        a. Memperbarui informasi obat
        b. Restock Obat
    3. Laporan 
        a. Tampilkan laporan penjualan obat
        b. Tampilkan laporan restock obat
        c. Tampilkan saldo
    4. Lihat informasi obat dan member
        a. Tampilkan informasi obat
        b. Tampilkan informasi membership
    5. Exit

Setiap menyelesaikan program akan menyimpan data yang telah dilakukan ke dalam database
## Konsep
- Kasir perlu melakukan login terlebih dahulu
- Setiap restock obat akan menambah obat secara otomatis dan mengatur harga obat menjadi 120% nya
- Setiap member yang terdaftar akan mendapat harga langsung tanpa tambahan pajak yakni 100%
- Setiap penjualan dapat menghasilkan 1 struk disimpan ke export
- Setiap melakukan restock obat atau penjualan obat akan terekam dalam laporan dengan kode Penjualan obat (A0) dan Restock obat (Z0)
- Setiap transaksi akan berdampak ke saldo apotek

## Isi Class
    
    1. Apotek
        a. pembelianObat()
        b. pembelianObat(@param)
        c. pembuatanMemberBaru()
        d. updateInformasiObat()
        e. pemesananObat()
        f. showLaporanPenjualan()
        g. showLaporanPemesanan()
        h. showSaldo()
        i. showInformasiObat()
        j. showInformasiMemberships()
        k. getObatById()
        l. getMemberById()
        m. getStrukById()
    
    2. Membership
        a. setId()
        b. setId(@param)
        c. getId()
        d. setNama()
        e. getNama()
        f. setAlamat()
        g. getAlamat()
        h. setJenisKelamin()
        i. getJenisKelamin()
        j. setNomorTelpon()
        k. getNomorTelpon()
        l. setUmur()
        m. getUmur()
    
    3. Obat
        a. setId()
        b. getId()
        c. setNamaObat()
        d. getNamaObat()
        e. setKodeObat()
        f. getKodeObat()
        g. setStockObat()
        h. getStockObat()
        i. setProductby()
        j. getProductby()
        k. setExpiredYear()
        l. getExpiredYear()
        m. getHarga()
        n. setHarga()
        o. getHargaMember()
    
    4. Laporan
       a. generateDate()
    
    5. PenjualanObat
        a. getId()
        b. setId()
        c. setId(@param)
        d. getIdObat()
        e. setIdObat()
        f. getPembeli()
        g. setPembeli()
        h. getNamaObat()
        i. setNamaObat()
        j. getJenisPembayaran()
        k. setJenisPembayaran
        l. getTotalItem()
        m. setTotalItem()
        n. getTotalHarga()
        o. setTotalHarga()
        p. getDate()
        q. setDate()
        r. setDate(@param)
    
    6. RestockObat
        a. setId()
        b. setId(@param)
        c. getId()
        d. setKodeObat()
        e. getKodeObat()
        f. setNamaObat()
        g. getNamaObat()
        h. setSupplier()
        i. getSupplier()
        j. getDate()
        k. setDate()
        l. setDate(@param)
        m. getStockObat()
        n. setStockObat()
        o. getTotalHarga()
        p. setTotalHarga()
        q. setHarga()
        r. getHarga()
    
    7. Saldo
        a. setPengeluaran()
        b. getPengeluaran()
        c. setPendapatan()
        d. getPendapatan()
        e. getLaba()
    
    8. Struk
        a. cetak()
        b. setKeseluruhan()
        c. getId()
        d. setId()
        e. setDate()
        f. getDate()
        g. setTotalHargaKeseluruhan()
        h. getTotalHargaKeseluruhan()
        i. setBeforeDiskon()
        j. getBeforeDiskon()
        k. setNamaPembeli()
        l. getNamaPembeli()
        m. setJenisPembayaran()
        n. getJenisPembayaran()
        o. tambahPembelian()
        p. getBayar()
        q. setBayar()
