package net.joaolourenco.blog.authentication.services.impl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import net.joaolourenco.blog.authentication.services.api.ITokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
public class TokenService implements ITokenService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TokenService.class);

    private static String secretKey;
    private static long validityInMilliseconds;

    @PostConstruct
    public void init() {
        secretKey = "batatas";
        validityInMilliseconds = (1000 * 86400);
    }

    @Override
    public String createToken(Long userId, String actions, Date expiration) {
        return Jwts.builder()
                .setSubject(userId.toString())
                .claim("claims", actions)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .setExpiration(expiration)
                .compact();
    }

    @Override
    public Date getExpiration() {
        Long now = (new Date()).getTime();

        Long tokenValidityInMilliseconds = validityInMilliseconds;

        return new Date(now + tokenValidityInMilliseconds);
    }

    @Override
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);

            return true;
        } catch (SignatureException e) {
            LOGGER.info("Invalid JWT signature.");
            LOGGER.trace("Invalid JWT signature trace: {}", e);
        } catch (MalformedJwtException e) {
            LOGGER.info("Invalid JWT token.");
            LOGGER.trace("Invalid JWT token trace: {}", e);
        } catch (ExpiredJwtException e) {
            LOGGER.info("Expired JWT token.");
            LOGGER.trace("Expired JWT token trace: {}", e);
        } catch (UnsupportedJwtException e) {
            LOGGER.info("Unsupported JWT token.");
            LOGGER.trace("Unsupported JWT token trace: {}", e);
        } catch (IllegalArgumentException e) {
            LOGGER.info("JWT token compact of handler are invalid.");
            LOGGER.trace("JWT token compact of handler are invalid trace: {}", e);
        }

        return false;
    }

}
