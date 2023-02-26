package ua.malysh.dto;

import io.micronaut.core.annotation.Introspected;

@Introspected
public record UserPublicDto(
    Long id,
    String firstName,
    String lastName
) {
}
