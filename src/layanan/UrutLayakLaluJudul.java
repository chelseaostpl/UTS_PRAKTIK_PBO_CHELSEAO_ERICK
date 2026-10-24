package layanan;

import model.Koleksi;

import java.util.Comparator;

/**
 * Urutan berlapis: koleksi layak pinjam tampil lebih dulu,
 * lalu diurutkan berdasarkan judul (A-Z, tidak peka huruf besar/kecil).
 */
public class UrutLayakLaluJudul implements Comparator<Koleksi> {
    private static final Comparator<Koleksi> ATURAN = Comparator
            .comparing((Koleksi k) -> !k.layakDipinjam())
            .thenComparing(Koleksi::getJudul, String.CASE_INSENSITIVE_ORDER);

    @Override
    public int compare(Koleksi a, Koleksi b) {
        return ATURAN.compare(a, b);
    }
}