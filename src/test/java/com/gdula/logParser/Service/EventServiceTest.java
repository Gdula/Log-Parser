package com.gdula.logParser.Service;

import com.gdula.logParser.model.Event;
import com.gdula.logParser.model.Log;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class EventServiceTest {
    @Test
    void isEventWithId() {
        EventService eventService = new EventService();
        List<Event> eventList = new ArrayList<>();
        eventList.add(new Event("a", 3l, "a", "123", true));

        assertEquals(eventService.isEventWithId("a", eventList), true);

    }
}