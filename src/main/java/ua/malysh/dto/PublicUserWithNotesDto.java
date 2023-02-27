package ua.malysh.dto;

import java.util.List;

import io.micronaut.core.annotation.Introspected;

@Introspected
public record PublicUserWithNotesDto(
        Long id,
        String nickname,
        List<PublicNoteDto> notes) {

}
