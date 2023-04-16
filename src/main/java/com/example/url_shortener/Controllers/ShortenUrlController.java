package com.example.url_shortener.Controllers;

import com.example.url_shortener.DTO.ShortenUrlRequestDTO;
import com.example.url_shortener.Services.ShortenUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("")
public class ShortenUrlController {

    ShortenUrlService shortenUrlService;

    @Autowired
    ShortenUrlController(ShortenUrlService shortenUrlService) {
        this.shortenUrlService = shortenUrlService;
    }

    @PostMapping("/shorten")
    public ResponseEntity<String> shortenUrl(@RequestBody ShortenUrlRequestDTO request) {
        String uniqueIdentifier = shortenUrlService.shortenUrl(request);
        final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
        return ResponseEntity.ok().body(baseUrl + "/" + uniqueIdentifier);
    }

    @GetMapping("/{uuid}")
    public ModelAndView accessUrl(@PathVariable String uuid) {
        String url = shortenUrlService.getUrl(uuid);
        return new ModelAndView("redirect:" + url);
    }

}
