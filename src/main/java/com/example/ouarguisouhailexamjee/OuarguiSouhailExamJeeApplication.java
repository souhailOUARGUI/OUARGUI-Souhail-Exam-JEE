package com.example.ouarguisouhailexamjee;

import com.example.ouarguisouhailexamjee.entities.Client;
import com.example.ouarguisouhailexamjee.repositories.ClientRepository;
import com.example.ouarguisouhailexamjee.repositories.CreditRepository;
import com.example.ouarguisouhailexamjee.repositories.RemboursementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class OuarguiSouhailExamJeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OuarguiSouhailExamJeeApplication.class, args);
    }

@Bean
    CommandLineRunner commandLineRunner(ClientRepository clientRepository,
                                        CreditRepository creditRepository,
                                        RemboursementRepository remboursementRepository
                                        ) {
        return args -> {
                      Stream.of("souhail","Mohamed","fatima").forEach(name -> {
              Client client = new Client();
              client.setNom(name);
              client.setEmail(name+"@gmail.com");
              clientRepository.save(client);
          });


        };
    }


}
