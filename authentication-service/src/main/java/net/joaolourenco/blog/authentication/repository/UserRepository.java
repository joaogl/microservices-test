package net.joaolourenco.blog.authentication.repository;

import net.joaolourenco.blog.authentication.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}