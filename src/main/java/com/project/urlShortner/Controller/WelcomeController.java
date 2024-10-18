package com.project.urlShortner.Controller;


import com.project.urlShortner.Model.UrlDB;
import com.project.urlShortner.Service.urlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WelcomeController {

    @Autowired
    urlService urlService;

    @GetMapping("/")
    public String Greet(){
        return "Welcome to Url Shortener Backend";
    }

    /*
    post request to db which returns the hashValue
     */
    @PostMapping("/url")
    public String shortUrl(@RequestParam String url){
        return urlService.shortUrl(url);
    }

    /*
    get request end point which returns the original url
     */
    @GetMapping("/url")
    public String findUrl(@RequestParam String value){

        return urlService.findUrl(value);
    }



}
