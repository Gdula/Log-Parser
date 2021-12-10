package com.gdula.logParser.Service;


import com.gdula.logParser.jsonParser.JsonParser;
import com.gdula.logParser.model.Event;
import com.gdula.logParser.model.Log;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class EventService {

    public boolean isEventWithId(String id, List<Event> events) {
        return events.stream().anyMatch(x -> x.getId().equals(id));
    }


    public List<Event> getEvents() {
        List<Log> logs = new ArrayList<>();
        List<Event> events = new ArrayList<>();
        try {
            logs = JsonParser.getLogs("src/main/resources/logfile.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Log firstLog;
        Log secondLog;
        long duration = 0;
        boolean alert;

        for (int i = 0; i < logs.size(); i++) {
            for (int j = 1; j < logs.size() - 1; j++) {
                firstLog = logs.get(i);
                secondLog = logs.get(j);
                if (firstLog.getId().equals(secondLog.getId()) && !isEventWithId(firstLog.getId(), events) &&
                        !firstLog.getTimestamp().equals(secondLog.getTimestamp())) {
                    if (secondLog.getTimestamp() > firstLog.getTimestamp()) {
                        duration = secondLog.getTimestamp() - firstLog.getTimestamp();
                    } else if (secondLog.getTimestamp() < firstLog.getTimestamp()) {
                        duration = firstLog.getTimestamp() - secondLog.getTimestamp();
                    }
                    alert = duration > 4;
                    events.add(new Event(firstLog.getId(), duration, firstLog.getType(), firstLog.getHost(), alert));
                }

            }
        }

        return events;
    }


}
