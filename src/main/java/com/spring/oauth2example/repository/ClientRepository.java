package com.spring.oauth2example.repository;

import com.spring.oauth2example.entity.AppClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<AppClient, String> {

    AppClient findByClientId(String clientId);

}