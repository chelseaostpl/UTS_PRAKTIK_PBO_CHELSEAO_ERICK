import layanan.EksporKatalog;
import layanan.KatalogPerpustakaan;
import eksepsi.PustakaException;
import layanan.UrutLayakLaluJudul;
import model.BerkasDigital;
import model.BukuCetak;
import model.Majalah;
import model.Terarsip;

import java.io.IOException;
import java.util.ArrayList;
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
        katalog.tambah(bk1);
        katalog.tambah(bk2);
        katalog.tambah(mj1);
        katalog.tambah(mj2);
        katalog.tambah(bd1);
        katalog.tambah(bd2);

        System.out.println("=== Status Koleksi (polimorfik)=== ");
        katalog.cetakStatus();

        System.out.println();
        System.out.println("===  Interface Terarsip ===");
        List<Terarsip> arsip = new ArrayList<>();
        arsip.add(bk1);
        arsip.add(bk2);
        arsip.add(mj1);
        arsip.add(mj2);
        for (Terarsip t : arsip) {
            System.out.println(t.ringkasanArsip());
        }

        System.out.println();
        System.out.println("===  Urut Layak Lalu Judul ===");
        katalog.urut(new UrutLayakLaluJudul());
        katalog.cetakStatus();

        System.out.println();
        System.out.println("=== Peminjaman & Eksepsi ===");
        cobaPinjam(katalog, "BK-001");   // berhasil
        cobaPinjam(katalog, "BK-001");   // sedang dipinjam
        cobaPinjam(katalog, "BK-002");   // tidak layak (diperbaiki)
        cobaPinjam(katalog, "MJ-001");   // tidak layak (edisi terbaru)
        cobaPinjam(katalog, "BD-001");   // berhasil
        cobaPinjam(katalog, "XX-999");   // tidak ditemukan

        System.out.println();
        System.out.println(" Status setelah peminjaman ");
        katalog.cetakStatus();

        System.out.println();
        System.out.println("=== Ekspor ke katalog.txt ===");
        try {
            new EksporKatalog().ekspor(katalog, "katalog.txt");
            System.out.println("Berhasil menulis katalog.txt");
        } catch (IOException e) {
            System.out.println("Gagal menulis berkas: " + e.getMessage());
        }
    }

    private static void cobaPinjam(KatalogPerpustakaan katalog, String kode) {
        try {
            katalog.pinjam(kode);
            System.out.println("[BERHASIL] " + kode + " berhasil dipinjam.");
        } catch (PustakaException e) {
            System.out.println("[GAGAL] " + e.getMessage());
        }
    }
}
