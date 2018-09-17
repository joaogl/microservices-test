package net.joaolourenco.blog.common.exceptions.exceptions;

import net.joaolourenco.blog.common.exceptions.CommonException;
import net.joaolourenco.blog.common.exceptions.Error;

public class LoginException extends CommonException {

    private static final long serialVersionUID = 5472479908801371116L;

    public LoginException(Error error) {
        super(error);
    }

    public LoginException(String error) {
        super(new Error(error));
    }

}