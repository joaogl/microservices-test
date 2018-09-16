package net.joaolourenco.blog.authentication.services.api;

import java.util.Date;

public interface ITokenService {

    String createToken(final Long idUser, final String lstActions, Date expiration);

    boolean validateToken(String token);

    Date getExpiration();

}
