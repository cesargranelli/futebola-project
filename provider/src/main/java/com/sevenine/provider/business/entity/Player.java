package com.sevenine.provider.business.entity;

import com.sevenine.provider.business.enumerated.ProviderEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public final class Player {
    private Long id;
    private String uuid;
    private String name;
    private String slug;
    private String shortName;
    private String position;
    private Long shirtNumber;
    private Team team;
    private Long idOrigin;
    private ProviderEnum provider;
    private LocalDate createdAt;

    public Player createPlayer(Long id, String name, String shortName, String position, Long shirtNumber,
                               ProviderEnum provider, Team team) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.slug = generatedSlug();
        this.shortName = shortName;
        this.position = position;
        this.shirtNumber = shirtNumber;
        this.idOrigin = id;
        this.provider = provider;
        this.team = team;
        this.createdAt = LocalDate.now();

        return this;
    }

    private String generatedSlug() {
        return this.name.toLowerCase().replace(" ", "-")
                .replaceAll("[áàâãä]", "a")
                .replaceAll("[éèêẽë]", "e")
                .replaceAll("[íìîĩï]", "i")
                .replaceAll("[óòôõö]", "o")
                .replaceAll("[úùûũü]", "u")
                .replaceAll("[ç]", "c");
    }
}
