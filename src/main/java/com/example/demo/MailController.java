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
        log.info("!!! GET test22 with picture template={}, phone={}, inn={}", template, phone, inn);
        System.out.println("!!! GET test22");

        URL imageUrl;
        try {
            //imageUrl = new URL("http://www.401khelpcenter.com/syndicate/img/AF-Logo_Brown_Small.gif");
            //imageUrl = new URL("https://www.w3schools.com/images/picture.jpg");
            //imageUrl = new URL("https://www.google.com/images/srpr/logo11w.png");
            imageUrl = new URL("https://ktonanovenkogo.ru/image/finik.jpg");
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
        log.info("!!! GET test template={}, phone={}, inn={}", template, phone, inn);
        System.out.println("!!! GET test");

        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/pixel")
    public ResponseEntity<?> getPixel(){
        log.info("!!! GET test pixel");
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/pixel.jpg")
    public ResponseEntity<?> getPixelJPG(){
        log.info("!!! GET test pixel.jpg");
        return ResponseEntity.ok().build();
    }
}