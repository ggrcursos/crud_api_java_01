package com.crud.ApiCrud.config;


        import com.crud.ApiCrud.service.ClientService;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {

    @Bean
    public ClientService confClientService() {
        return new ClientService();
    }
}
