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
        
        return noteRepository.findByUserId(id);
    }
    
    @Override
    public Note add(Note note) {
        return noteRepository.save(note);
    }

    @Override
    @Transactional
    public Note update(Note note) {
        return noteRepository.update(note);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }
}
