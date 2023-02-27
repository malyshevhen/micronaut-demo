package ua.malysh.service.impl;

import jakarta.inject.Singleton;
import lombok.RequiredArgsConstructor;
import ua.malysh.domain.User;
import ua.malysh.dto.PublicUserWithNotesDto;
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
    public PublicUserWithNotesDto getByIdFetchNotes(Long id) {
        var publicUserNotes = noteRepository.listByUserId(id);

        return userRepository.findOneById(id)
                .map(u -> new PublicUserWithNotesDto(u.id(), u.nickname(), publicUserNotes))
                .orElseThrow();
    }

    @Override
    @Transactional
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
