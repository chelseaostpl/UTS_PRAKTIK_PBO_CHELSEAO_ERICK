package layanan;

import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;
import eksepsi.PustakaException;
import model.Koleksi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KatalogPerpustakaan {
    private final List<Koleksi> daftar = new ArrayList<>();

    public void tambah(Koleksi koleksi) {
        daftar.add(koleksi);
    }

    public List<Koleksi> getDaftar() {
        return Collections.unmodifiableList(daftar);
    }

    /** Memproses seluruh koleksi secara polimorfik, tanpa percabangan tipe. */
    public void cetakStatus() {
        int nomor = 1;
        for (Koleksi k : daftar) {
            System.out.println(nomor++ + ". " + k.deskripsi());
            System.out.println("   Status: " + status(k));
        }
    }


    public void urut(Comparator<? super Koleksi> pembanding) {
        daftar.sort(pembanding);
    }

    private String status(Koleksi k) {
        if (k.isSedangDipinjam()) {
            return "SEDANG DIPINJAM";
        }
        return k.layakDipinjam() ? "LAYAK DIPINJAM" : "TIDAK LAYAK DIPINJAM";
    }

    private Koleksi cari(String kode) {
        for (Koleksi k : daftar) {
            if (k.getKodeKoleksi().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        return null;
    }


    public void pinjam(String kode) throws PustakaException {
        Koleksi k = cari(kode);
        if (k == null) {
            throw new PustakaException("Koleksi dengan kode " + kode + " tidak ditemukan di katalog.");
        }
        if (k.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException(k.getJudul());
        }
        if (!k.layakDipinjam()) {
            throw new KoleksiTidakLayakException(k.getJudul());
        }
        k.setSedangDipinjam(true);
    }


    public void kembalikan(String kode) throws PustakaException {
        Koleksi k = cari(kode);
        if (k == null) {
            throw new PustakaException("Koleksi dengan kode " + kode + " tidak ditemukan di katalog.");
        }
        k.setSedangDipinjam(false);
    }
}
