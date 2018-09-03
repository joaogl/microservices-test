package net.joaolourenco.blog.authentication.service.impl;

import net.joaolourenco.blog.authentication.domain.User;
import net.joaolourenco.blog.authentication.repository.UserRepository;
import net.joaolourenco.blog.authentication.service.api.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericServiceImpl implements GenericService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

}