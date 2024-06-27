package br.com.bittencourt.user_api.services.impl;

import br.com.bittencourt.user_api.domain.User;
import br.com.bittencourt.user_api.repositories.UserRepository;
import br.com.bittencourt.user_api.services.UserService;
import br.com.bittencourt.user_api.services.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuario not found"));
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
