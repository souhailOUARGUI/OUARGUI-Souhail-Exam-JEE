package com.example.ouarguisouhailexamjee.dtos;


import com.example.ouarguisouhailexamjee.enums.BienType;
import lombok.Data;

@Data
public class CreditImmobilierDTO {
    private Long id;
    private double montant;
    private int dureeRemboursement;
    private String dateDemande;
    private String dateAcceptation;
    private String creditStatut;
    private double tauxInteret;
    private BienType bienType;
}
