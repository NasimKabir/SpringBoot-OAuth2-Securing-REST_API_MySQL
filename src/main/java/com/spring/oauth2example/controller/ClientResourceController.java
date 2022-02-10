package com.spring.oauth2example.controller;

import com.spring.oauth2example.entity.AppClient;
import com.spring.oauth2example.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/v1/client")
public class ClientResourceController {
    private final ClientService clientService;

    @Autowired
    public ClientResourceController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<?> appClientCreate(@RequestBody AppClient appClient) {
        appClient = clientService.userClientCreate(appClient);
        return new ResponseEntity<>(appClient, CREATED);

    }
}
