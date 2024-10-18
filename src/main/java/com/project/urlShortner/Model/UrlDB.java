package com.project.urlShortner.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "urldb")
public class UrlDB {
    /*
    for using auto increment in postgres, we have to specify sequence generator, and its allocation size
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "urldb_seq")
    @SequenceGenerator(name = "urldb_seq", sequenceName = "urldb_seq", allocationSize = 1)
    public int id;
    public String url;
    public String hashvalue;

    public UrlDB() {
    }

    public UrlDB(int id, String url, String hashvalue) {
        this.id = id;
        this.url = url;
        this.hashvalue = hashvalue;
    }

    @Override
    public String toString() {
        return "UrlDB{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", hashvalue='" + hashvalue + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl(String url) {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHashvalue() {
        return hashvalue;
    }

    public void setHashvalue(String hashvalue) {
        this.hashvalue = hashvalue;
    }
}
