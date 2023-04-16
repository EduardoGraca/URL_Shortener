package com.example.url_shortener.DTO.Mappers;

import com.example.url_shortener.DAO.Url;
import com.example.url_shortener.DTO.ShortenUrlRequestDTO;

public class UrlMapper {
    static public Url ShortenUrlRequestToUrl(ShortenUrlRequestDTO shortenUrlRequestDTO) {
        return new Url(shortenUrlRequestDTO.getUrl());
    }
}
