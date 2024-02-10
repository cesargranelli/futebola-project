package com.sevenine.player.application.usecase.output;

public record PagenateOutput<T>(Object content, int page, int size, int totalPages) {
}
