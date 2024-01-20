package com.sevenine.client.application.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.client.business.Client;
import com.sevenine.client.infrastructure.mongodb.document.ClientDocument;
import com.sevenine.client.infrastructure.mongodb.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@RequiredArgsConstructor
@Service
public class LeagueService {

    private final ClientRepository repository;

    private final ObjectMapper mapper;

    public Client create(Client newClient) {
        Client client = findByDocument(newClient.getDocument());
        if (isNull(client)) {
            ClientDocument clientDocument = mapper.convertValue(newClient, ClientDocument.class);
            return mapper.convertValue(repository.save(clientDocument), Client.class);
        }
        return mapper.convertValue(client, Client.class);
    }

    public Client findByDocument(String document) {
        ClientDocument clientDocument = repository.findByDocument(document).orElse(null);
        return mapper.convertValue(clientDocument, Client.class);
    }

}
