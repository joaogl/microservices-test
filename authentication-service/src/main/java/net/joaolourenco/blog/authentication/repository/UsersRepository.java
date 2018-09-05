package net.joaolourenco.blog.authentication.repository;

import net.joaolourenco.common.authentication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, String> {
}
