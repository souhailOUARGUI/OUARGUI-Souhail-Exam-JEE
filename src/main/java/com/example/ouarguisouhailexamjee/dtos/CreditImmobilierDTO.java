package com.example.ouarguisouhailexamjee.dtos;


import com.example.ouarguisouhailexamjee.enums.BienType;
import lombok.Data;

@Data
public class CreditImmobilierDTO extends CreditDTO{
    private Long id;
    private double montant;
    private int dureeRemboursement;
    private String dateDemande;
    private String dateAcceptation;
    private String creditStatut;
    private double tauxInteret;
    private BienType bienType;
    private ClientDTO client;
}
