package ua.malysh.domain;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.validation.Validated;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Validated
@MappedEntity("notes")
public class Note {
    @Id
    @GeneratedValue
    private Long id;
    private final @NotBlank String body;
    private final Long userId;
    
    public Note(
        @NotBlank
        String body,
        Long userId
    ) {
        this.body = body;
        this.userId = userId;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Note note = (Note) o;
        return Objects.equals(id, note.id) && Objects.equals(
            body,
            note.body
        ) && Objects.equals(userId, note.userId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, body, userId);
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getBody() {
        return body;
    }
    
    public Long getUserId() {
        return userId;
    }
}
