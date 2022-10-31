package com.example.firstCrawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Port;
import java.util.List;


@Service
public class APIService {

//    @Autowired // dependency injection: instead "new" object
//    private MockSightDAO sightDAO;

//    public List<Sight> getSights(APIQueryParameter param) {
//        return sightDAO.find(param);
//    }
    @Autowired
    private APIRepository repository;

    public List<Sight> getSights(String zone) {
        return repository.findByZone(zone);
    }
}
