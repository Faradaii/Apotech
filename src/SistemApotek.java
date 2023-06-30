interface SistemApotek {
    public void pembelianObat();
    public void pembelianObat(Boolean buyAgain, String jenisPembayaran, String pembeli, String strukId);
    public void pembuatanMemberBaru();
    public void updateInformasiObat();
    public void pemesananObat();
    public void showLaporanPenjualan();
    public void showLaporanPemesanan();
    public void showSaldo();
    public void showInformasiObat();
    public void showInformasiMemberships();
}