package nl.reactiverest.service.user;

import nl.reactiverest.data.document.User;

import java.util.Optional;

/**
 *
 */
public interface UserAuthenticationService {

    Optional<String> login(String username, String password);

    Optional<User> findByToken(String token);

}