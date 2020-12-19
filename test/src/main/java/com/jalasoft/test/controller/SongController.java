package com.jalasoft.test.controller;

import com.jalasoft.test.model.TranslatedSong;
import com.jalasoft.test.model.TranslatorRequest;
import com.jalasoft.test.service.SongService;
import com.jalasoft.test.utils.ResponseBody;
import com.jalasoft.test.utils.ResponseConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping("/translate")
    public ResponseBody getTranslate(@RequestBody TranslatorRequest translatorRequest){
        TranslatedSong translatedSong = songService.getSongTranslated(translatorRequest);
        return new ResponseBody(translatedSong, ResponseConstants.SUCCESS_STATUS, ResponseConstants.ERROR_MESSAGE);
    }
}
