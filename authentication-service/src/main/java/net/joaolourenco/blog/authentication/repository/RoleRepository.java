package net.joaolourenco.blog.authentication.repository;

import net.joaolourenco.blog.authentication.domain.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
}