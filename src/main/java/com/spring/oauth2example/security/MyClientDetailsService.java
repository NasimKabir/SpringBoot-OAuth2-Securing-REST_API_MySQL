package com.spring.oauth2example.security;
import com.spring.oauth2example.entity.AppClient;
import com.spring.oauth2example.repository.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service(value ="clientDetailsService")
public class MyClientDetailsService implements ClientDetailsService {

    private Logger log = LoggerFactory.getLogger(MyClientDetailsService.class);
    @Autowired
    private ClientRepository cRepo;

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        AppClient c=cRepo.findByClientId(clientId);
        log.info("Client", c);
        System.out.println(c);

        if(c==null)
            throw new ClientRegistrationException("client with "+clientId +" is not available");



        return new MyClientDetails(c);
    }
}
