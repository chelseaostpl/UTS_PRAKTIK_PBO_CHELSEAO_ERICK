package eksepsi;

public class KoleksiSedangDipinjamException extends PustakaException {
    private static final long serialVersionUID = 1L;

    public KoleksiSedangDipinjamException(String judul) {
        super(String.format(
            "Maaf, \"%s\" sedang dipinjam oleh anggota lain. Silakan coba lagi setelah koleksi dikembalikan.", 
            judul
        ));
    }
}