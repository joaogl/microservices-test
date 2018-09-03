package net.joaolourenco.blog.authentication.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.joaolourenco.blog.authentication.model.JwtUser;
import org.springframework.stereotype.Component;

@Component
public class JwtGenerator {

    public String generate(JwtUser jwtUser) {

        Claims claims = Jwts.claims()
                .setSubject(jwtUser.getUsername());

        claims.put("userId", String.valueOf(jwtUser.getId()));
        claims.put("role", String.valueOf(jwtUser.getRole()));

        return Jwts.builder()
                .setExpiration(null)
                .setClaims(claims)
                .signWith(SignatureAlgorithm.ES512, JwtValidator.secret)
                .compact();

    }

}
