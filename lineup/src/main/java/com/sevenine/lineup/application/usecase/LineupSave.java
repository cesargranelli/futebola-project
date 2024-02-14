package com.sevenine.lineup.application.usecase;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sevenine.lineup.application.usecase.input.LineupInput;
import com.sevenine.lineup.application.usecase.output.LineupOutput;
import com.sevenine.lineup.business.entity.Lineup;
import com.sevenine.lineup.business.rules.lineup.LineupValidationRules;
import com.sevenine.lineup.infrastructure.repository.PlayerServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class LineupSave {

    private final PlayerServiceRepository playerServiceRepository;
    private final ObjectMapper mapper;
    private final List<LineupValidationRules> rules;

    public LineupOutput execute(LineupInput input) {
        Lineup lineup = mapper.convertValue(input, Lineup.class);
        // verifica se a rodada permite alterações (antes do início)

        // valida quantidade de jogadores titulares
        // valida quantidade de jogadores reservas
        // valida quantidade de jogadores por posição mediante formação escolhida/informada
        rules.forEach(rule -> rule.execute(lineup));

        // busca informações do apostador
        // valida as pontuações distribuídas vs pontuação disponível para o apostador (punter)
        // busca lineup ativo fazendo o bloqueio se encontrar
        // salva o novo lineup
        // se sucesso ao salvar, vai no lineup anterior e marca como inativado
        // se der erro, volta a marcação de ativo no lineup anterior e informa apostador sobre o erro
        return null;
    }

}
