package eksepsi;

/** Induk seluruh kesalahan layanan perpustakaan. */
public class PustakaException extends Exception {
    private static final long serialVersionUID = 1L;

    public PustakaException(String pesan) {
        super(pesan);
    }
}