package eksepsi;

/** Induk seluruh kesalahan layanan perpustakaan. */
public class PustakaException extends Exception {
    public PustakaException(String pesan) {
        super(pesan);
    }
}
