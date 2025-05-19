package com.example.ouarguisouhailexamjee.dtos;


import lombok.Data;

@Data
public class CreditPersonnelDTO {
    private Long id;
    private double montant;
    private int dureeRemboursement;
    private String dateDemande;
    private String dateAcceptation;
    private String creditStatut;
    private double tauxInteret;
    private String motif;
}
