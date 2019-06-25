package nl.reactiverest.data.repository;

import nl.reactiverest.data.document.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

/**
 *
 */
@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {

    Mono<User> findByUsernameAndPassword(String username, String password);

    Mono<User> findByAuthenticationTokenToken(String authenticationToken);

}