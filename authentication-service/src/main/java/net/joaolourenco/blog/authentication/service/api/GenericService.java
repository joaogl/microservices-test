package net.joaolourenco.blog.authentication.service.api;


import net.joaolourenco.blog.authentication.domain.User;

import java.util.List;

public interface GenericService {

    User findByUsername(String username);

    List<User> findAllUsers();

}