package com.sevenine.lineup.application.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.lineup.application.service.GameClient;
import com.sevenine.lineup.application.service.LineupRepository;
import com.sevenine.lineup.application.usecase.input.LineupInput;
import com.sevenine.lineup.application.usecase.output.LineupOutput;
import com.sevenine.lineup.business.entity.Lineup;
import com.sevenine.lineup.business.rules.lineup.LineupValidationRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class LineupSave {

    private final LineupRepository lineupRepository;
    private final ObjectMapper objectMapper;
    private final List<LineupValidationRules> rules;
    private final GameClient gameClient;

    public LineupOutput execute(LineupInput input) {
        Lineup lineup = objectMapper.convertValue(input, Lineup.class);

        lineup.setGamer(gameClient.findGamerByUser(input.gamer().uuidUser()));

        lineup.executeRules(rules);

        // busca lineup ativo fazendo o bloqueio se encontrar
        Lineup lineupSaved = lineupRepository.save(lineup);// salva o novo lineup
        // se sucesso ao salvar, vai no lineup anterior e marca como inativado
        // se der erro, volta a marcação de ativo no lineup anterior e informa apostador sobre o erro
        return objectMapper.convertValue(lineupSaved, LineupOutput.class);
    }

}
