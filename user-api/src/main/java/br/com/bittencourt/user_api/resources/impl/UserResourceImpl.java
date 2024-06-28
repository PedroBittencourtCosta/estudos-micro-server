package br.com.bittencourt.user_api.resources.impl;

import br.com.bittencourt.user_api.domain.User;
import br.com.bittencourt.user_api.resources.UserResource;
import br.com.bittencourt.user_api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserResourceImpl implements UserResource {

    private final UserService userService;
    @Override
    public ResponseEntity<User> findById(Long id) {
        return ResponseEntity.status(200).body(userService.findById(id));
    }

    @Override
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.status(200).body(userService.findAll());
    }
}
