package com.example.firstCrawler;

import com.example.firstCrawler.Sight;
import com.example.firstCrawler.APIQueryParameter;
import com.example.firstCrawler.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/SightAPI", produces = MediaType.APPLICATION_JSON_VALUE)
public class APIController {
    @Autowired
    private APIService apiService;

    @GetMapping
    public ResponseEntity<List<Sight>> getProducts(@ModelAttribute APIQueryParameter param) {
        List<Sight> sights = apiService.getSights(param.getZone()+"區");
        System.out.println(param.getZone());
        return ResponseEntity.ok(sights);
    }

}

