package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
@RequestMapping("v1")
@Validated
@RequiredArgsConstructor
@Slf4j
public class MailController {

    @SneakyThrows
    @GetMapping(value = "/test22", produces = MediaType.IMAGE_GIF_VALUE)
    public ResponseEntity<byte[]> getTest(@RequestParam String template,
                                          @RequestParam String phone,
                                          @RequestParam String inn) {
        log.info("GET test22 with picture template={}, phone={}, inn={}", template, phone, inn);

        // пишем в БД

        URL imageUrl;
        try {
            imageUrl = new URL("https://www.google.com/images/srpr/logo11w.png");
        } catch (MalformedURLException ex) {
            throw new RuntimeException(ex);
        }
        byte[] imageBytes;
        try (InputStream in = imageUrl.openStream()) {
            imageBytes = IOUtils.toByteArray(in);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_GIF);

        return new ResponseEntity<byte[]>(imageBytes, headers, HttpStatus.OK);
    }

    @SneakyThrows
    @GetMapping(value = "/test")
    public ResponseEntity<?> getTest22(@RequestParam String template,
                                       @RequestParam String phone,
                                       @RequestParam String inn) {
        log.info("GET test template=}, phone={}, inn={}", template, phone, inn);
        // пишем в БД
        return ResponseEntity.ok().build();
    }
}