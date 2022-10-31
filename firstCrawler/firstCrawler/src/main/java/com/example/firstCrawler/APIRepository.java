package com.example.firstCrawler;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface APIRepository extends MongoRepository<Sight, String> {
    List<Sight> findByZone(String zone);
}
