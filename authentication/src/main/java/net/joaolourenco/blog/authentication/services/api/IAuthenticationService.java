package net.joaolourenco.blog.authentication.services.api;

public interface
IAuthenticationService {

    Long createCredentials(String username, String password);

    Boolean checkCredentials(String username, String password);

}