package model;

public class Majalah extends Koleksi implements Terarsip {
    private final int edisi;
    private final String bulanTerbit;
    private final String nomorRak;
    private final int lantai;
    private final boolean edisiTerbaru;

    public Majalah(String kodeKoleksi, String judul, int tahunTerbit,
                   int edisi, String bulanTerbit, String nomorRak, int lantai,
                   boolean edisiTerbaru) {
        super(kodeKoleksi, judul, tahunTerbit);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.nomorRak = nomorRak;
        this.lantai = lantai;
        this.edisiTerbaru = edisiTerbaru;
    }

    public int getEdisi() {
        return edisi;
    }

    public String getBulanTerbit() {
        return bulanTerbit;
    }

    public boolean isEdisiTerbaru() {
        return edisiTerbaru;
    }

    @Override
    public String nomorRak() {
        return nomorRak;
    }

    @Override
    public String lokasiLantai() {
        return "Lantai " + lantai;
    }

    /** Layak apabila bukan edisi terbaru. */
    @Override
    public boolean layakDipinjam() {
        return !edisiTerbaru;
    }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | edisi " + edisi + " | " + bulanTerbit + " | rak " + nomorRak
                + " (lantai " + lantai + ") | " + (edisiTerbaru ? "edisi terbaru" : "bukan terbaru");
    }
}
