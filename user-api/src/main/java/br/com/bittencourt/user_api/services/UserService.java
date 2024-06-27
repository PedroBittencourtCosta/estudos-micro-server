package br.com.bittencourt.user_api.services;

import br.com.bittencourt.user_api.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User findById(Long id);

    List<User> findAll();

}
