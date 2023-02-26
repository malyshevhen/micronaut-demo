package ua.malysh.controller;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import lombok.RequiredArgsConstructor;
import ua.malysh.domain.User;
import ua.malysh.dto.UserWithNotesPublicDto;
import ua.malysh.service.interfaces.UserService;

import java.util.List;

@RequiredArgsConstructor
@Controller(value = "/api/persons")
public class UserController {
    private final UserService userService;
    
    @Get
    public List<User> getAll() {
        return userService.getAll();
    }
    
    @Get(value = "/{id}")
    public User getById(Long id) {
        return userService.getById(id);
    }
    
    @Get(value = "/with-notes/{id}")
    public UserWithNotesPublicDto getByIdWithNotes(Long id) {
        return userService.getByIdFetchNotes(id);
    }
    
    @Post("/add")
    public User addPerson(User user) {
        return userService.add(user);
    }
}
