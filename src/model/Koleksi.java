package model;

/**
 * Kelas induk (abstract) untuk seluruh jenis koleksi perpustakaan.
 */
public abstract class Koleksi {
    private final String kodeKoleksi;
    private final String judul;
    private final int tahunTerbit;
    private boolean sedangDipinjam;

    public Koleksi(String kodeKoleksi, String judul, int tahunTerbit) {
        this.kodeKoleksi = kodeKoleksi;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    public String getKodeKoleksi() {
        return kodeKoleksi;
    }

    public String getJudul() {
        return judul;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public boolean isSedangDipinjam() {
        return sedangDipinjam;
    }

    public void setSedangDipinjam(boolean sedangDipinjam) {
        this.sedangDipinjam = sedangDipinjam;
    }


    public abstract boolean layakDipinjam();
  
   
    public String deskripsi() {
        return kodeKoleksi + " | " + judul + " | " + tahunTerbit;
    }
}
