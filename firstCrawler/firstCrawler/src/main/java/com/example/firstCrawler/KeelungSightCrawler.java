package com.example.firstCrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class KeelungSightCrawler {


    private Document doc;
    private Document linkDoc;
    private List<Sight> sightDB = new ArrayList<>();

    @PostConstruct
    public void init() {

    }

    public List<Sight> getAllSights() {
        try {
            doc = Jsoup.connect("https://www.travelking.com.tw/tourguide/taiwan/keelungcity/").get();
        } catch (IOException e) {
            System.out.println("error");
        }

        String sightName;
        String zone;
        String category;
        String photoURL;
        String description;
        String address;
        int id = 0;

        Elements sightElement = null;
        Elements siblingElements = null;
        Element unorderedList = null;
        Elements orderedList = null;
        Elements links = null;

        sightElement = doc.getElementsByClass("box");
        siblingElements = sightElement.select("h4");
        for (Element element : siblingElements) {
            unorderedList = element.nextElementSibling();
            orderedList = unorderedList.children();
            zone = element.text();

            links = orderedList.select("a[href]");
            int index = 0;
            for (Element link : links) {
                try {
                    linkDoc = Jsoup.connect("https://www.travelking.com.tw" + link.attr("href")).get();
                } catch (IOException e) {
                    System.out.println("Cannot find particular website");
                }
                Element sampleDiv = linkDoc.getElementById("point_area");
                Elements sampleCite = linkDoc.getElementsByTag("cite");
                // set value
                category = new String();
                char[] cate = new char[20];
                cate = sampleCite.text().toCharArray();
                for(int i=6; cate[i] != ' '; i++)
                    category += cate[i];

                sightName = sampleDiv.select("meta[itemprop=name]").first().attr("content");
                photoURL = sampleDiv.select("meta[itemprop=image]").first().attr("content");
                description = sampleDiv.select("meta[itemprop=description]").first().attr("content");
                address = sampleDiv.select("meta[itemprop=address]").first().attr("content");
                id++;

                sightDB.add(new Sight(sightName, zone, category, photoURL, description, address, id));
            }
        }
        return sightDB;
    }

    public void clearAllSights() {
        sightDB.clear();
    }

//    public List<Sight> getItem(String zone) {
//
//        String sightName;
//        String category;
//        String photoURL;
//        String description;
//        String address;
//
//        Elements headers;
//        Element sibling = null;
//        Elements children = null;
//        Elements links;
//
//        zone = zone + '區';
//
//        headers = doc.getElementsByTag("h4");
//        for (Element header : headers) {
//            if(header.text().equals(zone)) {
//                sibling = header.nextElementSibling();
//                children = sibling.children();
//                break;
//            }
//        }
//
//        links = children.select("a[href]");
//        int index = 0;
//        for(Element link : links) {
//            try {
//                linkDoc = Jsoup.connect("https://www.travelking.com.tw" + link.attr("href")).get();
//            } catch (IOException e) {
//                System.out.println("Cannot find particular website");
//            }
//            Element sampleDiv = linkDoc.getElementById("point_area");
//            Elements sampleCite = linkDoc.getElementsByTag("cite");
//
//            // set value
//            category = new String();
//            char[] cate = new char[20];
//            cate = sampleCite.text().toCharArray();
//            for(int i=6; cate[i] != ' '; i++)
//                category += cate[i];
//
//            sightName = sampleDiv.select("meta[itemprop=name]").first().attr("content");
//            photoURL = sampleDiv.select("meta[itemprop=image]").first().attr("content");
//            description = sampleDiv.select("meta[itemprop=description]").first().attr("content");
//            address = sampleDiv.select("meta[itemprop=address]").first().attr("content");
//
//            sightDB.add(new Sight(sightName, zone, category, photoURL, description, address));
//        }
//
//        return sightDB;
//    }
}
