package ua.malysh.service.impl;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import ua.malysh.domain.Note;
import ua.malysh.repository.NoteRepository;
import ua.malysh.service.interfaces.NoteService;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Singleton
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;
    
    @Override
    @Transactional
    public List<Note> getByPersonId(Long id) {
        
        return noteRepository.findByPersonId(id);
    }
    
    @Override
    public Note add(Note note) {
        return noteRepository.save(note);
    }
}
