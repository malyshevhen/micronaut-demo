package ua.malysh.service.impl;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import ua.malysh.domain.User;
import ua.malysh.dto.UserWithNotesPublicDto;
import ua.malysh.repository.NoteRepository;
import ua.malysh.repository.UserRepository;
import ua.malysh.service.interfaces.UserService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Singleton
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final NoteRepository noteRepository;
    
    @Override
    @Transactional
    public List<User> getAll() {
        return StreamSupport.stream(
                userRepository.findAll().spliterator(),
                false
            )
            .toList();
    }
    
    @Override
    @Transactional
    public User getById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("No person with id: '"
                + id + "' was found!"));
    }
    
    @Override
    @Transactional
    public UserWithNotesPublicDto getByIdFetchNotes(Long id) {
        var person = userRepository.findById(id).orElseThrow(
            () -> new NoSuchElementException("No person with id: '"
                + id + "' was found!")
        );
        var notes = noteRepository.findByPersonId(id);
        
        return new UserWithNotesPublicDto(person, notes);
    }
    
    @Override
    @Transactional
    public User add(User user) {
        return userRepository.save(user);
    }
}
