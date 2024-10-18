package com.project.urlShortner.Service;

import com.project.urlShortner.Model.UrlDB;
import com.project.urlShortner.Repository.urlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class urlService {

    @Autowired
    private urlRepo urlRepo;

    /*
    it encodes the url, save it to db and then find the hash and return the short url
     */
    public String shortUrl(String url) {
        UrlDB urlDB = new UrlDB();

        if(urlRepo.existsUrl(url)){
        return "https://www.chintu.com/" + urlRepo.findByHash(url);
        }
        String hash = Base62.encode(url);
        urlDB.setUrl(url);
        urlDB.setHashvalue(hash);
        urlRepo.save(urlDB);
        return "https://www.chintu.com/" + urlRepo.findByHash(url);

    }

    /*
      returns the original url to the user
     */
    public String findUrl(String hash) {
        return urlRepo.findByUrl(hash);
    }
}
