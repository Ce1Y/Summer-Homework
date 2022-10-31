package com.example.firstCrawler;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "Sights")
public class Sight implements java.io.Serializable {

    private String sightName;
    private String zone;
    private String category;
    private String photoURL;
    private String description;
    private String address;

    @Id
    private int id;

    public Sight() {}

    public Sight(String sightName, String zone, String category, String photoURL, String description, String address, int id) {
        this.sightName = sightName;
        this.zone = zone;
        this.category = category;
        this.photoURL = photoURL;
        this.description = description;
        this.address = address;
        this.id = id;
    }

    public void setSightName(String sightName) {
        this.sightName = sightName;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSightName() {
        return sightName;
    }

    public String getZone() {
        return zone;
    }

    public String getCategory() {
        return category;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "SightName: " + sightName + "\n" +
                "Zone: " + zone + "\n" +
                "Category: " + category + "\n" +
                "PhotoURL: " + photoURL + "\n" +
                "Description: " + description + "\n" +
                "Address: " + address + "\n";
    }

}
