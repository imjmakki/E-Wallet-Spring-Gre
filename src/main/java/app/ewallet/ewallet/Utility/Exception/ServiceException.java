package app.ewallet.ewallet.Utility.Exception;

public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 7079920785459163281L;

    private int status;

    private String message;

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public ServiceException(int status, String message) {
        super();
        this.status = status;
        this.message = message;
    }

}
