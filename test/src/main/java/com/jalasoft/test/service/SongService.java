package com.jalasoft.test.service;

import com.jalasoft.test.model.TranslatedSong;
import com.jalasoft.test.model.TranslatorRequest;
import com.jalasoft.test.repository.APIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {

    @Autowired
    private APIRepository apiRepository;

    public TranslatedSong getSongTranslated(TranslatorRequest translatorRequest){
        TranslatedSong translatedSong = apiRepository.translateSong(translatorRequest);
        return translatedSong;
    }
}
