package com.jalasoft.test.repository;

import com.jalasoft.test.model.TranslatedSong;
import com.jalasoft.test.model.TranslatorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class APIRepository {


    private final String URL = "https://api-b2b.backenster.com/b1/api/v3/translate";
    @Autowired
    private RestTemplate restTemplate;

    /**
     *
     * @param translatorRequest
     * @return The translated song
     */
    public TranslatedSong translateSong(TranslatorRequest translatorRequest){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+"a_ItVQVpy8n2JpN7SO382k7W0vMPV3O27WE9QQ0PXkAAAPDX9HEHRS5VJmcPuOPGzZoH2U0PglLUVbv2W0");
        HttpEntity<String> request =
                new HttpEntity(translatorRequest, headers);
        TranslatedSong translatedSong = restTemplate.postForObject(this.URL, request, TranslatedSong.class);
        return translatedSong;
    }
}
