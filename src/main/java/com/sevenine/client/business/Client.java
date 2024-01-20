package com.sevenine.client.business;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Client {
    private String uuid;
    private String name;
    private String document;
    private LocalDate birthdate;
}
