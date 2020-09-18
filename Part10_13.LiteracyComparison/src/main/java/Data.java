/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author maciejcirka
 */
public class Data {
    
    private String country;
    private int year;
    private String gender;
    private String literacyPercent;
    
    
    public Data(String country, int year, String gender, String literacyPercent) {
        this.country = country;
        this.year = year;
        this.gender = gender;
        this.literacyPercent = literacyPercent;
    }

    public String getCountry() {
        return country;
    }

    public int getYear() {
        return year;
    }

    public String getGender() {
        return gender;
    }

    public String getLiteracyPercent() {
        return literacyPercent;
    }

    @Override
    public String toString() {
        return country + " (" + year + "), " + gender + ", " + literacyPercent;
    }
    
    
    
    
    
}
