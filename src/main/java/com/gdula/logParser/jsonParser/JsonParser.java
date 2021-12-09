package com.gdula.logParser.jsonParser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gdula.logParser.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class JsonParser {
    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    public static ObjectMapper getDefaultObjectMapper() {
        return new ObjectMapper();
    }

    public static JsonNode parse(String src) throws IOException {
        return objectMapper.readTree(src);
    }

    public static <A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException {
        return objectMapper.treeToValue(node, clazz);
    }

    public static List<Log> getLogs(String path) throws FileNotFoundException {
        List<Log> logsList = new ArrayList<>();
        File file = new File(path);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            try {
                JsonNode node = JsonParser.parse(line);
                Log log = JsonParser.fromJson(node, Log.class);
                logsList.add(log);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return logsList;
    }

    public JsonParser() {
    }
}
