package com.sevenine.provider.infrastructure.repository.document;

import com.sevenine.provider.business.enumerated.ProviderEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Getter
@Setter
@Document("teams")
public class TeamDocument {
    @Id
    private String id;
    private String uuid;
    private String name;
    private String slug;
    @Field(name = "short_name")
    private String shortName;
    @Field(name = "name_code")
    private String nameCode;
    @Field(name = "id_origin")
    private Long idOrigin;
    private ProviderEnum provider;
    @Field(name = "created_at")
    private LocalDate createdAt;
}
