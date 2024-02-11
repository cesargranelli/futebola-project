package com.sevenine.lineup.application.usecase.output;

public record PagenateOutput<T>(Object content, int page, int size, long totalPages) {
}
