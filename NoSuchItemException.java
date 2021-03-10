public class NoSuchItemException extends Exception{
    private static final long serialVersionUID = 1L;

    public NoSuchItemException(String message){
        super(message);
    }
}