package com.sevenine.provider.business.entity;

import com.sevenine.provider.business.enumerated.ProviderEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class Team {
    private String id;
    private String uuid;
    private String name;
    private String slug;
    private String shortName;
    private String nameCode;
    private Long idOrigin;
    private ProviderEnum provider;
    private LocalDate createdAt;

    public Team createTeam(Long id, String name, String shortName, String nameCode, ProviderEnum provider) {
        this.uuid = UUID.randomUUID().toString();
        this.name = name;
        this.slug = generatedSlug();
        this.shortName = shortName;
        this.nameCode = nameCode;
        this.idOrigin = id;
        this.provider = provider;
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
