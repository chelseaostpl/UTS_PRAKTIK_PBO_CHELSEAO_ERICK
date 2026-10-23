package eksepsi;

public class KoleksiTidakLayakException extends PustakaException {
    public KoleksiTidakLayakException(String judul) {
        super("Maaf, \"" + judul + "\" belum bisa dipinjam saat ini karena tidak memenuhi syarat peminjaman. "
                + "Silakan pilih koleksi lain.");
    }
}
