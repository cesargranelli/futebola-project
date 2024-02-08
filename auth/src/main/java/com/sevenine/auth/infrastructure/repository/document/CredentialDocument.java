package com.sevenine.auth.infrastructure.repository.document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CredentialDocument {
    private String username;
    private String password;
}
