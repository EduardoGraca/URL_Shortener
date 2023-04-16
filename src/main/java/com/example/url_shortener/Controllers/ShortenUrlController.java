package com.example.url_shortener.Controllers;

import com.example.url_shortener.DTO.ShortenUrlRequestDTO;
import com.example.url_shortener.Services.ShortenUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> accessUrl(@PathVariable String uuid) {
        String url = shortenUrlService.getUrl(uuid);
        if (url != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Location", url);
            return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("UUID was not not found!");
        }
    }

    @DeleteMapping("/remove")
    public ResponseEntity<String> deleteUrl(@RequestParam String uuid) {
        shortenUrlService.deleteUrl(uuid);
        return ResponseEntity.status(HttpStatus.OK).body("URL with UUID \"" + uuid + "\" deleted!");
    }

}
