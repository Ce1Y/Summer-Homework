package com.example.firstCrawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.firstCrawler.KeelungSightCrawler;

@Component
public class DBInitializer implements ApplicationRunner {
    @Autowired
    private APIRepository repository;
    @Autowired
    private KeelungSightCrawler crawler;

//    private DBInitializer(APIRepository repository) {
//        this.repository = repository;
//    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        repository.saveAll(crawler.getAllSights());
        crawler.clearAllSights();
    }
}
