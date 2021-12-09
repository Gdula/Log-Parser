package com.gdula.logParser.controller;

import com.gdula.logParser.jsonParser.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

@Service
public class AppController {


    public void run() {
        try {
            JsonParser.getLogs("src/main/resources/logfile.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
