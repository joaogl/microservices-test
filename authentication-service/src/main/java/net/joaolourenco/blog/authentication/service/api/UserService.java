package net.joaolourenco.blog.authentication.service.api;

import net.joaolourenco.common.authentication.User;

import java.util.Optional;

public interface UserService {

    User save(User user);

    Optional<User> find(String id);

    Optional<User> findByUsername(String username);

}