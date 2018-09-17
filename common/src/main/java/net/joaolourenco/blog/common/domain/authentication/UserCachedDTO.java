package net.joaolourenco.blog.common.domain.authentication;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserCachedDTO implements Serializable {

    private String username;
    private String password;

}