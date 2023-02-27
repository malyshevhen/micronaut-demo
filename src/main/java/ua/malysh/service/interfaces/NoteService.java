package ua.malysh.service.interfaces;

import ua.malysh.domain.Note;

import java.util.List;

public interface NoteService {
    List<Note> getByPersonId(Long id);
    
    Note add(Note note);

    Note update(Note note);

    void deleteById(Long id);
}
