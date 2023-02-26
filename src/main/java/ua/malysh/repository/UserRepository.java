package ua.malysh.repository;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import ua.malysh.domain.User;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface UserRepository extends CrudRepository<User, Long> {
}
