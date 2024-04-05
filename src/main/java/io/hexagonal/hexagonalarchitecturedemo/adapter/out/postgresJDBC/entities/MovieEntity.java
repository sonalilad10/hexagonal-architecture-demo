package io.hexagonal.hexagonalarchitecturedemo.adapter.out.postgresJDBC.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table(name = "movies")
public record MovieEntity(
        @Id
        @Column("id")
        Long id,
        @Column("title")
        String title,
        @Column("description")
        String description,
        @Column("releasedate")
        LocalDate releaseDate,
        @Column("directorname")
        String directorName,

        @Column("version")
        @Version
        Integer version

) {
}
