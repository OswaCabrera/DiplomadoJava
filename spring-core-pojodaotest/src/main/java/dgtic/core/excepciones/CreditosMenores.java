package dgtic.core.excepciones;

public class CreditosMenores extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public CreditosMenores(String message) {
        super(message);
    }
}
