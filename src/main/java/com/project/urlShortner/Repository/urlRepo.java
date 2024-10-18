package com.project.urlShortner.Repository;

import com.project.urlShortner.Model.UrlDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface urlRepo extends JpaRepository<UrlDB,Integer> {
    /*
    find the hashvalue by the url
     */

    @Query("select u.hashvalue from UrlDB u where u.url = :url")
    String findByHash(@Param("url") String url);

    /*
    find the url by hashvalue
     */

    @Query("Select h.url from UrlDB h where h.hashvalue = :value")
    String findByUrl(@Param("value") String value);

    @Query("Select count(u)>0 from UrlDB u where u.url = :url")
    boolean existsUrl(@Param("url") String url);
}
