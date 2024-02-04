package com.sevenine.provider.business.entity;

import com.sevenine.provider.business.enumerated.ProviderEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

import static java.util.Objects.isNull;

@Getter
@Setter
public class Team {
    private String id;
    private String uuid;
    private String name;
    private String slug;
    private String shortName;
    private String nameCode;
    private int idOrigin;
    private ProviderEnum provider;
    private LocalDate createdAt;

    public void setUuid(String uuid) {
        this.uuid = (uuid == null) ? UUID.randomUUID().toString() : uuid;
    }

    public void setSlug(String slug) {
        this.slug = (slug == null) ? generatedSlug() : slug;
    }

    public void setIdOrigin(int idOrigin) {
        if (idOrigin < 1) {
            this.idOrigin = Integer.parseInt(id);
            this.id = null;
        } else {
            this.idOrigin = idOrigin;
        }
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = (isNull(createdAt)) ? LocalDate.now() : createdAt;
    }

    private String generatedSlug() {
        return this.name.toLowerCase().replace(" ", "-");
    }
}
