package com.gdula.logParser.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    private String id;
    private String state;
    private Long timestamp;
    private String type;
    private String host;
}
