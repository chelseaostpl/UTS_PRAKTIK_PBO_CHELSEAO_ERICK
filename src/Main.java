import layanan.EksporKatalog;
import layanan.KatalogPerpustakaan;
import eksepsi.PustakaException;
import layanan.UrutLayakLaluJudul;
import model.BerkasDigital;
import model.BukuCetak;
import model.Majalah;
import model.Terarsip;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BukuCetak bk1 = new BukuCetak("BK-001", "Java How to Program", 2022, 620, "A-12", 1, false);
        BukuCetak bk2 = new BukuCetak("BK-002", "Basis Data Relasional", 2021, 410, "B-04", 2, true);
        Majalah mj1 = new Majalah("MJ-001", "Info Teknologi Edisi 88", 2026, 88, "Agustus", "C-01", 1, true);
        Majalah mj2 = new Majalah("MJ-002", "Info Teknologi Edisi 87", 2026, 87, "Juli", "C-02", 1, false);
        BerkasDigital bd1 = new BerkasDigital("BD-001", "Panduan Pemrograman Java", 2024, 15, "unduh.polmed.ac.id/bd001");
        BerkasDigital bd2 = new BerkasDigital("BD-002", "Jurnal Rekayasa Perangkat", 2025, 8, "unduh.polmed.ac.id/bd002");

        KatalogPerpustakaan katalog = new KatalogPerpustakaan();
        List.of(bk1, bk2, mj1, mj2, bd1, bd2).forEach(katalog::tambah);

        System.out.println("=== Status Koleksi (polimorfik)=== ");
        katalog.cetakStatus();

        System.out.println("\n===  Interface Terarsip ===");
        List<Terarsip> arsip = List.of(bk1, bk2, mj1, mj2);
        arsip.forEach(t -> System.out.println(t.ringkasanArsip()));

        System.out.println("\n===  Urut Layak Lalu Judul ===");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        System.out.println("\n=== Peminjaman & Eksepsi ===");
        List.of("BK-001", "BK-001", "BK-002", "MJ-001", "BD-001", "XX-999")
            .forEach(kode -> cobaPinjam(katalog, kode));

        System.out.println("\n Status setelah peminjaman ");
        katalog.cetakStatus();

        System.out.println("\n=== Ekspor ke katalog.txt ===");
        eksporKatalog(katalog, "katalog.txt");
    }

    private static void cobaPinjam(KatalogPerpustakaan katalog, String kode) {
        try {
            katalog.pinjam(kode);
            System.out.println("[BERHASIL] " + kode + " berhasil dipinjam.");
        } catch (PustakaException e) {
            System.out.println("[GAGAL] " + e.getMessage());
        }
    }

    private static void eksporKatalog(KatalogPerpustakaan katalog, String namaBerkas) {
        try {
            new EksporKatalog().ekspor(katalog, namaBerkas);
            System.out.println("Berhasil menulis " + namaBerkas);
        } catch (IOException e) {
            System.out.println("Gagal menulis berkas: " + e.getMessage());
        }
    }
}