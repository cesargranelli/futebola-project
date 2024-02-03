package com.sevenine.player.application.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.player.business.entity.Player;
import com.sevenine.player.infrastructure.repository.document.PlayerDocument;
import com.sevenine.player.infrastructure.repository.mongodb.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PlayerService {

    private final PlayerRepository repository;

    private final ObjectMapper mapper;

    public List<Player> listPlayers() {
        List<PlayerDocument> documents = repository.findAll();

        return documents.stream().map(document -> mapper.convertValue(document, Player.class))
                .collect(Collectors.toList());
    }

}
