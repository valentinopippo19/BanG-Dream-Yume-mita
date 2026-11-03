package com.waividol;

import java.util.List;

public record QuizQuestion(String id, String question, List<String> options, int answer) {}
