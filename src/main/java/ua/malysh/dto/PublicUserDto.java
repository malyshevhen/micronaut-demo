package ua.malysh.dto;

import io.micronaut.data.annotation.MappedEntity;

@MappedEntity("users")
public record PublicUserDto(
    Long id,
    String nickname) {
    
}
