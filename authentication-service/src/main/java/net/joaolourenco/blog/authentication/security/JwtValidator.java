package net.joaolourenco.blog.authentication.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import net.joaolourenco.blog.authentication.model.JwtUser;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

    public static String secret = "ÇLIDHFLI DHFANSLDFKUAS DFÇAS.DFLIU 1Ç234 O1J2K3Ç4L";

    public JwtUser validate(String token) {

        JwtUser jwtUser = null;

        try {

            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JwtUser();

            jwtUser.setUsername(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get("userId")));
            jwtUser.setRole((String) body.get("role"));
        } catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
    }


}
