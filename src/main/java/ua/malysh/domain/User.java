package ua.malysh.domain;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

import javax.validation.constraints.NotNull;

@MappedEntity("persons")
public record User(
    @Id @GeneratedValue Long id,
    @NotNull String firstName,
    @NotNull String lastName,
    @NotNull String nickname,
    @NotNull String email,
    @NotNull String password) {
}
