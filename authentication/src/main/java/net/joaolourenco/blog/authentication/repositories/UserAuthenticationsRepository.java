package net.joaolourenco.blog.authentication.repositories;

import net.joaolourenco.blog.authentication.domain.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthenticationsRepository extends JpaRepository<UserAuthentication, String> {

    UserAuthentication findOneByUsername(String username);

}
