package ua.malysh.repository;

import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;
import ua.malysh.domain.Note;
import ua.malysh.dto.PublicNoteDto;

import java.util.List;

@JdbcRepository(dialect = Dialect.POSTGRES)
public interface NoteRepository extends CrudRepository<Note, Long> {
    List<Note> findByUserId(Long personId);
    
    @Query(
        "select n.id, n.user_id, u.nickname, n.body from notes n left join users u on u.id = n.user_id where n.user_id = :id"
    )
    List<PublicNoteDto> listByUserId(Long id);
}
