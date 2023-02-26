package ua.malysh.domain;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.MappedProperty;

import javax.validation.constraints.NotNull;

@MappedEntity("notes")
public record Note(
    @Id @GeneratedValue Long id,
    @NotNull String body,
    @MappedProperty("person_id") Long personId) {
}

