package com.waividol;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.List;

public final class JsonCatalog {
    private final ObjectMapper mapper = new ObjectMapper();
    private final List<Character> characters;
    private final List<QuizQuestion> questions;

    public JsonCatalog() throws Exception {
        try (InputStream in = resource("/data/characters.json")) {
            characters = mapper.readValue(in, new TypeReference<>() {});
        }
        try (InputStream in = resource("/data/quiz.json")) {
            questions = mapper.readValue(in, new TypeReference<>() {});
        }
    }

    private InputStream resource(String path) {
        InputStream in = JsonCatalog.class.getResourceAsStream(path);
        if (in == null) throw new IllegalStateException("No se encontró el recurso JSON: " + path);
        return in;
    }

    public List<Character> characters() { return characters; }
    public List<QuizQuestion> questions() { return questions; }
    public Character findCharacter(String id) { return characters.stream().filter(c -> c.id().equals(id)).findFirst().orElse(null); }
    public QuizQuestion findQuestion(String id) { return questions.stream().filter(q -> q.id().equals(id)).findFirst().orElse(null); }
}
