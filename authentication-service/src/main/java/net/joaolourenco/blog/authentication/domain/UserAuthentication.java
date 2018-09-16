package net.joaolourenco.blog.authentication.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
public class UserAuthentication implements Serializable {

    private static final long serialVersionUID = 2396654715654621670L;

    @Id
    @Column
    private Long id;

    @Column(unique = true)
    private String username;

    @Column
    private String password;

    @Column
    private String salt;

}