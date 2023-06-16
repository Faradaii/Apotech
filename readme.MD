
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

- Apotek
    ~ pembelianObat()
    ~ pembelianObat(@param)
    ~ pembuatanMemberBaru()
    ~ updateInformasiObat()
    ~ pemesananObat()
    ~ showLaporanPenjualan()
    ~ showLaporanPemesanan()
    ~ showSaldo()
    ~ showInformasiObat()
    ~ showInformasiMemberships()
    ~ getObatById()
    ~ getMemberById()
    ~ getStrukById()

- Membership
    ~ setId()
    ~ setId(@param)
    ~ getId()
    ~ setNama()
    ~ getNama()
    ~ setAlamat()
    ~ getAlamat()
    ~ setJenisKelamin()
    ~ getJenisKelamin()
    ~ setNomorTelpon()
    ~ getNomorTelpon()
    ~ setUmur()
    ~ getUmur()

- Obat
    ~ setId()
    ~ getId()
    ~ setNamaObat()
    ~ getNamaObat()
    ~ setKodeObat()
    ~ getKodeObat()
    ~ setStockObat()
    ~ getStockObat()
    ~ setProductby()
    ~ getProductby()
    ~ setExpiredYear()
    ~ getExpiredYear()
    ~ getHarga()
    ~ setHarga()
    ~ getHargaMember()

- Laporan
   ~  generateDate()

- PenjualanObat
    ~ getId()
    ~ setId()
    ~ setId(@param)
    ~ getIdObat()
    ~ setIdObat()
    ~ getPembeli()
    ~ setPembeli()
    ~ getNamaObat()
    ~ setNamaObat()
    ~ getJenisPembayaran()
    ~ setJenisPembayaran
    ~ getTotalItem()
    ~ setTotalItem()
    ~ getTotalHarga()
    ~ setTotalHarga()
    ~ getDate()
    ~ setDate()
    ~ setDate(@param)

- RestockObat
    ~ setId()
    ~ setId(@param)
    ~ getId()
    ~ setKodeObat()
    ~ getKodeObat()
    ~ setNamaObat()
    ~ getNamaObat()
    ~ setSupplier()
    ~ getSupplier()
    ~ getDate()
    ~ setDate()
    ~ setDate(@param)
    ~ getStockObat()
    ~ setStockObat()
    ~ getTotalHarga()
    ~ setTotalHarga()
    ~ setHarga()
    ~ getHarga()

- Saldo
    ~ setKasBersih()
    ~ getKasBersih()
    ~ setLaba()
    ~ getLaba()

- Struk
    ~ cetak()
    ~ setKeseluruhan()
    ~ getId()
    ~ setId()
    ~ setDate()
    ~ getDate()
    ~ setTotalHargaKeseluruhan()
    ~ getTotalHargaKeseluruhan()
    ~ setBeforeDiskon()
    ~ getBeforeDiskon()
    ~ setNamaPembeli()
    ~ getNamaPembeli()
    ~ setJenisPembayaran()
    ~ getJenisPembayaran()
    ~ tambahPembelian()
    ~ getBayar()
    ~ setBayar()