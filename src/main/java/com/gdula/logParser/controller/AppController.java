package com.gdula.logParser.controller;

import com.gdula.logParser.Service.EventService;


public class AppController {
    EventService service = new EventService();

    public void run() {
        service.saveEvents();

    }
}
