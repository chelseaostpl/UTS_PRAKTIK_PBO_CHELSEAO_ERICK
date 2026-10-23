package layanan;

import model.Koleksi;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class EksporKatalog {

    /** Menulis seluruh koleksi ke berkas teks dengan kolom sejajar rapi. */
    public void ekspor(KatalogPerpustakaan katalog, String namaBerkas) throws IOException {
        List<Koleksi> daftar = katalog.getDaftar();

        // Lebar kolom judul menyesuaikan judul terpanjang agar kolom tetap sejajar
        int lebarJudul = "JUDUL".length();
        for (Koleksi k : daftar) {
            lebarJudul = Math.max(lebarJudul, k.getJudul().length());
        }
        String format = "%-8s %-14s %-" + lebarJudul + "s %-6s %-13s %s%n";

        // try-with-resources: aliran otomatis ditutup
        try (BufferedWriter penulis = Files.newBufferedWriter(Path.of(namaBerkas))) {
            String header = String.format(format, "KODE", "JENIS", "JUDUL", "TAHUN", "KELAYAKAN", "DIPINJAM");
            penulis.write(header);
            penulis.write("-".repeat(header.length() - System.lineSeparator().length()));
            penulis.newLine();

            for (Koleksi k : daftar) {
                penulis.write(String.format(format,
                        k.getKodeKoleksi(),
                        k.getClass().getSimpleName(),
                        k.getJudul(),
                        String.valueOf(k.getTahunTerbit()),
                        k.layakDipinjam() ? "Layak" : "Tidak layak",
                        k.isSedangDipinjam() ? "Ya" : "Tidak"));
            }
        }
    }
}
