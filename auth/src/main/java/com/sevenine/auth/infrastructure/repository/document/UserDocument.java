package com.sevenine.auth.infrastructure.repository.document;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("users")
public class UserDocument {
    @Id
    private String id;
    private String uuid;
    private String name;
    private String nick; // TODO: retirar daqui e deixar para o módulo gamer
    private String birthdate;
    private ContactDocument contacts;
    private CredentialDocument credentials;
    private TeamDocument team;
}
