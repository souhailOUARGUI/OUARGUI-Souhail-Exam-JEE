package com.example.ouarguisouhailexamjee;

import com.example.ouarguisouhailexamjee.entities.Client;
import com.example.ouarguisouhailexamjee.entities.CreditImmobilier;
import com.example.ouarguisouhailexamjee.enums.*;
import com.example.ouarguisouhailexamjee.entities.CreditPersonnel;
import com.example.ouarguisouhailexamjee.entities.CreditProfessionnel;
import com.example.ouarguisouhailexamjee.repositories.ClientRepository;
import com.example.ouarguisouhailexamjee.repositories.CreditRepository;
import com.example.ouarguisouhailexamjee.repositories.RemboursementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
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
//                      Stream.of("souhail","Mohamed","fatima").forEach(name -> {
//              Client client = new Client();
//              client.setNom(name);
//              client.setEmail(name+"@gmail.com");
//              clientRepository.save(client);
//          });
        clientRepository.findAll().forEach(client -> {
            CreditPersonnel creditPersonnel = new CreditPersonnel();
            creditPersonnel.setMontant(Math.random() * 10000);
            creditPersonnel.setTauxInteret( 10);
            creditPersonnel.setDureeRemboursement(12);
            creditPersonnel.setCreditStatut(CreditStatut.PENDING);
            creditPersonnel.setMotif("etudes");
            creditPersonnel.setDateDemande(new Date());
            creditPersonnel.setDateAcceptation(new Date());
            creditPersonnel.setClient(client);

            creditRepository.save(creditPersonnel);

            CreditImmobilier creditImmobilier = new CreditImmobilier();
            creditImmobilier.setMontant(Math.random() * 10000);
            creditImmobilier.setTauxInteret( 10);
            creditImmobilier.setDureeRemboursement(12);
            creditImmobilier.setCreditStatut(CreditStatut.PENDING);
            creditImmobilier.setBienType(BienType.APPARTEMENT);
            creditImmobilier.setDateDemande(new Date());
            creditImmobilier.setDateAcceptation(new Date());
            creditImmobilier.setClient(client);

            creditRepository.save(creditPersonnel);


        });

        };
    }


}
