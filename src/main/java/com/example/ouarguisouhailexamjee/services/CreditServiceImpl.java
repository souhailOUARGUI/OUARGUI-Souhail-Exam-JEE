package com.example.ouarguisouhailexamjee.services;


import com.example.ouarguisouhailexamjee.dtos.*;
import com.example.ouarguisouhailexamjee.entities.*;
import com.example.ouarguisouhailexamjee.enums.BienType;
import com.example.ouarguisouhailexamjee.enums.CreditStatut;
import com.example.ouarguisouhailexamjee.repositories.ClientRepository;
import com.example.ouarguisouhailexamjee.repositories.CreditRepository;
import com.example.ouarguisouhailexamjee.repositories.RemboursementRepository;
import jakarta.transaction.Transactional;
import com.example.ouarguisouhailexamjee.mappers.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CreditServiceImpl implements CreditService {
    private CreditRepository creditRepository;
    private ClientRepository clientRepository;
    private RemboursementRepository remboursementRepository;
    private CreditMapperImpl dtoMapper;


    @Override
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client client = dtoMapper.fromClientDTO(clientDTO);
        Client savedClient = clientRepository.save(client);
        return dtoMapper.fromClient(savedClient);
    }

    @Override
    public List<ClientDTO> listClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.stream()
                .map(dtoMapper::fromClient)
                .collect(Collectors.toList());
    }

    @Override
    public CreditImmobilierDTO saveCreditImmobilier(Long clientId, double montant, BienType bienType) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        CreditImmobilier creditImmobilier = new CreditImmobilier();
        creditImmobilier.setMontant(montant);
        creditImmobilier.setBienType(bienType);
        creditImmobilier.setClient(client);
        creditImmobilier.setDateDemande(new Date());
        creditImmobilier.setCreditStatut(CreditStatut.PENDING);

        CreditImmobilier savedCredit = creditRepository.save(creditImmobilier);
        return dtoMapper.fromCreditImmobilier(savedCredit);
    }

    @Override
    public CreditPersonnelDTO saveCreditPersonnel(Long clientId, double montant, String motif) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        CreditPersonnel creditPersonnel = new CreditPersonnel();
        creditPersonnel.setMontant(montant);
        creditPersonnel.setMotif(motif);
        creditPersonnel.setClient(client);
        creditPersonnel.setDateDemande(new Date());
        creditPersonnel.setCreditStatut(CreditStatut.PENDING);

        CreditPersonnel savedCredit = creditRepository.save(creditPersonnel);
        return dtoMapper.fromCreditPersonnel(savedCredit);
    }

    @Override
    public CreditProfessionnelDTO saveCreditProfessionnel(Long clientId, double montant, String motif, String raisonSociale) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        CreditProfessionnel creditProfessionnel = new CreditProfessionnel();
        creditProfessionnel.setMontant(montant);
        creditProfessionnel.setMotif(motif);
        creditProfessionnel.setRaisonSociale(raisonSociale);
        creditProfessionnel.setClient(client);
        creditProfessionnel.setDateDemande(new Date());
        creditProfessionnel.setCreditStatut(CreditStatut.PENDING);

        CreditProfessionnel savedCredit = creditRepository.save(creditProfessionnel);
        return dtoMapper.fromCreditProfessionnel(savedCredit);
    }

    @Override
    public CreditDTO getCreditById(Long creditId) {
        Credit credit = creditRepository.findById(creditId)
                .orElseThrow(() -> new RuntimeException("Credit not found"));
        return dtoMapper.fromCredit(credit);
    }

    @Override
    public List<CreditDTO> listCredits() {
        return creditRepository.findAll().stream()
                .map(dtoMapper::fromCredit)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDTO getClient(Long clientId) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));
        return dtoMapper.fromClient(client);
    }

    @Override
    public ClientDTO updateClient(ClientDTO clientDTO) {
        Client client = clientRepository.findById(clientDTO.getId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        client.setNom(clientDTO.getNom());
        client.setEmail(clientDTO.getEmail());

        Client updatedClient = clientRepository.save(client);
        return dtoMapper.fromClient(updatedClient);
    }

    @Override
    public void deleteClient(Long clientId) {
        clientRepository.deleteById(clientId);
    }

    @Override
    public List<RemboursementDTO> remboursementList(Long creditId) {
        Credit credit = creditRepository.findById(creditId)
                .orElseThrow(() -> new RuntimeException("Credit not found"));

        List<Remboursement> remboursements = remboursementRepository.findByCreditId(creditId);
        return remboursements.stream()
                .map(dtoMapper::fromRemboursement)
                .collect(Collectors.toList());
    }


}
