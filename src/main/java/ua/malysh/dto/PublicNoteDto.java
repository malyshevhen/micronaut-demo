package ua.malysh.dto;

import io.micronaut.data.annotation.MappedEntity;

@MappedEntity("notes")
public record PublicNoteDto(
        Long id,
        Long userId,
        String nickname,
        String body) {

}
