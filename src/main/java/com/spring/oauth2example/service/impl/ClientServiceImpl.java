package com.spring.oauth2example.service.impl;

import com.spring.oauth2example.entity.AppClient;
import com.spring.oauth2example.repository.ClientRepository;
import com.spring.oauth2example.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public AppClient userClientCreate(AppClient appClient) {
        return clientRepository.save(appClient);
    }
}
