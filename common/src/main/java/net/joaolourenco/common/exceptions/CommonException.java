package net.joaolourenco.common.exceptions;

public class CommonException extends RuntimeException {

    private static final long serialVersionUID = -8128877683205023441L;

    private final Error error;

    public CommonException() {
        super("Error");
        this.error = new Error(null);
    }

    public CommonException(Error error) {
        super(error.getMessage());
        this.error = error;
    }

    public CommonException(String error) {
        super(error);
        this.error = new Error(error);
    }

    public Error getError() {
        return error;
    }

}
