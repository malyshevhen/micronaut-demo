package ua.malysh.repository;

import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import ua.malysh.domain.Note;

import java.util.List;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface NoteRepository extends CrudRepository<Note, Long> {
    List<Note> findByPersonId(Long personId);
}
