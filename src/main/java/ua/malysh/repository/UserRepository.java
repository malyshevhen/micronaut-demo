package ua.malysh.repository;

import java.util.Optional;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import ua.malysh.domain.User;
import ua.malysh.dto.PublicUserDto;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface UserRepository extends CrudRepository<User, Long> {
    
    Optional<User> findById(Long id);

    Optional<PublicUserDto> findOneById(Long id);
    
}
