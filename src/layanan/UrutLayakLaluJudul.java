package layanan;

import model.Koleksi;

import java.util.Comparator;

/**
 * Urutan berlapis: koleksi layak pinjam tampil lebih dulu,
 * lalu diurutkan berdasarkan judul (A-Z, tidak peka huruf besar/kecil).
 */
public class UrutLayakLaluJudul implements Comparator<Koleksi> {
    private final Comparator<Koleksi> aturan =
            Comparator.comparing((Koleksi k) -> !k.layakDipinjam())   // false (layak) lebih dulu
                    .thenComparing(Koleksi::getJudul, String.CASE_INSENSITIVE_ORDER);

    @Override
    public int compare(Koleksi a, Koleksi b) {
        return aturan.compare(a, b);
    }
}
