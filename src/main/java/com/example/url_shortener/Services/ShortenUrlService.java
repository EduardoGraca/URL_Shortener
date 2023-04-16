package com.example.url_shortener.Services;

import com.example.url_shortener.DAO.Url;
import com.example.url_shortener.DTO.Mappers.UrlMapper;
import com.example.url_shortener.DTO.ShortenUrlRequestDTO;
import com.example.url_shortener.Repository.UrlRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortenUrlService {

    private final UrlRepository urlRepository;

    @Autowired
    ShortenUrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Transactional
    public String shortenUrl(ShortenUrlRequestDTO requestDTO) {
        Url url = UrlMapper.ShortenUrlRequestToUrl(requestDTO);
        urlRepository.save(url);
        return url.getUniqueIdentifier();
    }

    public String getUrl(String uuid) {
        Url url = urlRepository.findByUniqueIdentifier(uuid);
        return url.getUrl();
    }
}
