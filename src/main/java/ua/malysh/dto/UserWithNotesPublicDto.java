package ua.malysh.dto;

import ua.malysh.domain.Note;
import ua.malysh.domain.User;

import java.util.List;

public record UserWithNotesPublicDto(
    Long id,
    String firstName,
    String lastName,
    List<Note> notes) {
    
    public UserWithNotesPublicDto(User user, List<Note> notes) {
        this(user.id(), user.firstName(), user.lastName(), notes);
    }
}
