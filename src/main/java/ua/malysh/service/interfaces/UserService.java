package ua.malysh.service.interfaces;

import ua.malysh.domain.User;
import ua.malysh.dto.PublicUserWithNotesDto;

import java.util.List;

public interface UserService {
    List<User> getAll();
    
    User getById(Long id);
    
    PublicUserWithNotesDto getByIdFetchNotes(Long id);
    
    User add(User user);

    void deleteById(Long id);
}
