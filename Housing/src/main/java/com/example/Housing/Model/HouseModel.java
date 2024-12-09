package com.example.Housing.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "houses")
public class HouseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bed_rooms")
    private int bedrooms;

    @Column(name = "bathrooms")
    private float bathrooms;

    @Column(name = "square_foots")
    private int squareFoots;

    @Column(name = "location")
    private String location;

    @Column(name = "sale_price")
    private long salePrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public float getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(float bathrooms) {
        this.bathrooms = bathrooms;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSquareFoots() {
        return squareFoots;
    }

    public void setSquareFoots(int squareFoots) {
        this.squareFoots = squareFoots;
    }

    public long getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(long salePrice) {
        this.salePrice = salePrice;
    }
}
