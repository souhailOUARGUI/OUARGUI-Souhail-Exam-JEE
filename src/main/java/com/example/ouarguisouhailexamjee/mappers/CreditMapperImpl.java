package com.example.ouarguisouhailexamjee.mappers;


import com.example.ouarguisouhailexamjee.dtos.*;
import com.example.ouarguisouhailexamjee.entities.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CreditMapperImpl {

    public CreditDTO fromCredit(Credit credit) {
        if (credit instanceof CreditPersonnel) {
            return fromCreditPersonnel((CreditPersonnel) credit);
        } else if (credit instanceof CreditImmobilier) {
            return fromCreditImmobilier((CreditImmobilier) credit);
        } else if (credit instanceof CreditProfessionnel) {
            return fromCreditProfessionnel((CreditProfessionnel) credit);
        } else {
            throw new RuntimeException("Credit type not found");
        }
    }

    public ClientDTO fromClient(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        return clientDTO;
    }

    public Client fromClientDTO(ClientDTO clientDTO) {
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO, client);
        return client;
    }


    public Credit fromCreditPersonnelDTO(CreditPersonnelDTO creditPersonnelDTO) {
        CreditPersonnel creditPersonnel = new CreditPersonnel();
        BeanUtils.copyProperties(creditPersonnelDTO, creditPersonnel);

        return creditPersonnel;
    }

    public CreditPersonnelDTO fromCreditPersonnel(CreditPersonnel creditPersonnel) {
        CreditPersonnelDTO creditPersonnelDTO = new CreditPersonnelDTO();
        BeanUtils.copyProperties(creditPersonnel, creditPersonnelDTO);
        creditPersonnelDTO.setType(creditPersonnel.getClass().getSimpleName());
        creditPersonnelDTO.setClient(fromClient(creditPersonnel.getClient()));

        return creditPersonnelDTO;
    }

    public CreditImmobilier fromCreditImmobilierDTO(CreditImmobilierDTO creditImmobilierDTO) {
        CreditImmobilier creditImmobilier = new CreditImmobilier();
        BeanUtils.copyProperties(creditImmobilierDTO, creditImmobilier);
        return creditImmobilier;
    }

    public CreditImmobilierDTO fromCreditImmobilier(CreditImmobilier creditImmobilier) {
        CreditImmobilierDTO creditImmobilierDTO = new CreditImmobilierDTO();
        BeanUtils.copyProperties(creditImmobilier, creditImmobilierDTO);
        creditImmobilierDTO.setType(creditImmobilier.getClass().getSimpleName());
        creditImmobilierDTO.setClient(fromClient(creditImmobilier.getClient()));
        return creditImmobilierDTO;
    }

    public CreditProfessionnel fromCreditProfessionnelDTO(CreditProfessionnelDTO creditProfessionnelDTO) {
        CreditProfessionnel creditProfessionnel = new CreditProfessionnel();
        BeanUtils.copyProperties(creditProfessionnelDTO, creditProfessionnel);
        return creditProfessionnel;
    }

    public CreditProfessionnelDTO fromCreditProfessionnel(CreditProfessionnel creditProfessionnel) {
        CreditProfessionnelDTO creditProfessionnelDTO = new CreditProfessionnelDTO();
        BeanUtils.copyProperties(creditProfessionnel, creditProfessionnelDTO);
        creditProfessionnelDTO.setType(creditProfessionnel.getClass().getSimpleName());
        creditProfessionnelDTO.setClient(fromClient(creditProfessionnel.getClient()));
        return creditProfessionnelDTO;
    }


  public RemboursementDTO fromRemboursement(Remboursement remboursement) {
        RemboursementDTO remboursementDTO = new RemboursementDTO();
        BeanUtils.copyProperties(remboursement, remboursementDTO);
        return remboursementDTO;
    }




}
