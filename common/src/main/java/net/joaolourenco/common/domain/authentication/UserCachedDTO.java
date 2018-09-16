package net.joaolourenco.common.domain.authentication;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class UserCachedDTO implements Serializable {

    Long id;
    String username;
    String token;
    Date expiration;
    List<String> permissions;

    public UserCachedDTO(Long id, String username, String token, Date expiration) {
        this.id = id;
        this.username = username;
        this.token = token;
        this.expiration = expiration;
    }

    public UserCachedDTO(Long id, String username, String token, Date expiration, List<String> permissions) {
        this.id = id;
        this.username = username;
        this.token = token;
        this.expiration = expiration;
        this.permissions = permissions;
    }

}