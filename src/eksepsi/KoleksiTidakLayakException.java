package eksepsi;

public class KoleksiTidakLayakException extends PustakaException {
    private static final long serialVersionUID = 1L;

    public KoleksiTidakLayakException(String judul) {
        super(String.format(
            "Maaf, \"%s\" belum bisa dipinjam saat ini karena tidak memenuhi syarat peminjaman. Silakan pilih koleksi lain.",
            judul
        ));
    }
}