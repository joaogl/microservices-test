package net.joaolourenco.common.authentication.models;

import lombok.Data;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.List;

@Data public class UserCached implements Serializable {

    Long id;
    String username;
    String token;
    DateTime expiration;
    List<String> permissions;

    public UserCached(Long id, String username, String token, DateTime expiration, List<String> permissions) {
        this.id = id;
        this.username = username;
        this.token = token;
        this.expiration = expiration;
        this.permissions = permissions;
    }

}