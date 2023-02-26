package ua.malysh.service.interfaces;

import ua.malysh.domain.User;
import ua.malysh.dto.UserWithNotesPublicDto;

import java.util.List;

public interface UserService {
    List<User> getAll();
    
    User getById(Long id);
    
    UserWithNotesPublicDto getByIdFetchNotes(Long id);
    
    User add(User user);
}
