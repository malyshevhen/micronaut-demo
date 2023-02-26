package ua.malysh.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import lombok.RequiredArgsConstructor;
import ua.malysh.domain.Note;
import ua.malysh.service.interfaces.NoteService;

import java.util.List;

@RequiredArgsConstructor
@Controller("/api/notes")
public class NoteController {
    private final NoteService noteService;
    
    @Get(value = "/{id}")
    public List<Note> getPersonNotesById(Long id) {
        return noteService.getByPersonId(id);
    }
    
    @Post("/add")
    public Note addNote(Note note) {
        return noteService.add(note);
    }
}
