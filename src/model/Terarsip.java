package model;

/**
 * Dipakai hanya oleh koleksi yang memiliki lokasi fisik di rak
 * (BukuCetak dan Majalah). BerkasDigital tidak menerapkannya.
 */
public interface Terarsip {
    String nomorRak();

    String lokasiLantai();

    default String ringkasanArsip() {
        return "Rak " + nomorRak() + ", " + lokasiLantai();
    }
}
