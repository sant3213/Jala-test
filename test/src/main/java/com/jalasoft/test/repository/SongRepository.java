package com.jalasoft.test.repository;

import com.jalasoft.test.model.TranslatorRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends MongoRepository<TranslatorRequest, String> {

    @Query("{'name' : ?0")
    TranslatorRequest findByName(String name);
}
