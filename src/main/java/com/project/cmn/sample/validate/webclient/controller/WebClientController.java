package com.project.cmn.sample.validate.webclient.controller;

import com.project.cmn.sample.validate.webclient.service.WebClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.SSLException;

@RequiredArgsConstructor
@RestController
public class WebClientController {
    private final WebClientService webClientService;

    @GetMapping("/retrieve/models")
    public void retrieveModels() throws SSLException {
        webClientService.retrieveModels();
    }
}
