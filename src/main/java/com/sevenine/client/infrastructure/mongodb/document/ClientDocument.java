package com.sevenine.client.infrastructure.mongodb.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("clients")
public class ClientDocument {
    @Id
    private String uuid;
    private String name;
    private String document;
    private String birthdate;
}
