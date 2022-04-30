/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dvd.model;

/**
 *
 * @author black
 */
public class DVDItem implements java.io.Serializable {

    private String title;
    private String year;
    private String genre;
    
    public DVDItem(String title,String year, String genre)
    {
        this.title=title;
        this.year=year;
        this.genre=genre;
        
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
