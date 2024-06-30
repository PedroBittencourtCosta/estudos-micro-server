package br.com.bittencourt.user_api.services.impl;

import br.com.bittencourt.user_api.domain.User;
import br.com.bittencourt.user_api.repositories.UserRepository;
import br.com.bittencourt.user_api.services.UserService;
import br.com.bittencourt.user_api.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Environment env;

    @Override
    public User findById(Long id) {
        log.info("USER_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port");
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuario not found"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
