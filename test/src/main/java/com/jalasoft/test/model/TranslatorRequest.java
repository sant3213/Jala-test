package com.jalasoft.test.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter

@Document(collection = "song")
public class TranslatorRequest {

    private String from;
    private String to;
    private String data;
    private String platform;

}
