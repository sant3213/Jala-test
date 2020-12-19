package com.jalasoft.test.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranslatedSong {

    private String err;
    private String result;
    private Integer cacheUse;
    private String source;
    private String from;
    private String sourceTransliteration;
    private String targetTransliteration;
}
