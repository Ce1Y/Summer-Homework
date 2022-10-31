//package com.example.firstCrawler;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import org.springframework.stereotype.Repository;
//
//import javax.annotation.PostConstruct;
//import javax.print.Doc;
//import java.io.IOException;
//import java.util.*;
//import java.util.stream.Collectors;
//
//@Repository
//public class MockSightDAO {
//    private List<Sight> sightDB = new ArrayList<>();
//
//    @PostConstruct
//    private void initDB() {
////        productDB.add(new Product("B0001", "Android Development (Java)", 380));
////        productDB.add(new Product("B0002", "Android Development (Kotlin)", 420));
////        productDB.add(new Product("B0003", "Data Structure (Java)", 250));
////        productDB.add(new Product("B0004", "Finance Management", 450));
////        productDB.add(new Product("B0005", "Human Resource Management", 330));
//    }
//
//    // get products
//    public List<Sight> find(APIQueryParameter param) {
//        String zone = Optional.ofNullable(param.getZone()).orElse(""); // "orElse" means return "" if no value is founded
//
////        sightDBInitialize();
////        try {
////            KeelungSightCrawler crawler = new KeelungSightCrawler();
////            sightDB = crawler.getItem(zone);
////        } catch (IOException e) {
////            System.out.println("Cannot find proper website");
////        }
//
//
//        return sightDB.stream()
//                .filter(s -> s.getZone().contains(zone))
////                .sorted(comparator)
//                .collect(Collectors.toList());
//    }
//
//    private void sightDBInitialize() {
//            sightDB.clear();
//    }
//}
