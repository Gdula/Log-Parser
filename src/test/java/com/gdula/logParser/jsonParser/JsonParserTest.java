package com.gdula.logParser.jsonParser;

import com.fasterxml.jackson.databind.JsonNode;
import com.gdula.logParser.jsonParser.pojo.SimpleTestCaseJsonPOJO;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {
    private final String simpleTestCaseJsonSource = "{ \"title\": \"Test\" }";

    @Test
    void simpleParse() throws IOException {
        JsonNode node = JsonParser.parse(simpleTestCaseJsonSource);
        assertEquals(node.get("title").asText(), "Test");
    }

    @Test
    void fromJson() throws IOException {
        JsonNode node = JsonParser.parse(simpleTestCaseJsonSource);
        SimpleTestCaseJsonPOJO pojo = JsonParser.fromJson(node, SimpleTestCaseJsonPOJO.class);

        assertEquals(pojo.getTitle(), "Test");
    }
}