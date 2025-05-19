package com.example.ouarguisouhailexamjee.entities;


import com.example.ouarguisouhailexamjee.enums.CreditStatut;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", length = 8)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double montant;
    private Date dureeRemboursement;
    private Date dateDemande;
    private Date dateAcceptation;
    @Enumerated(EnumType.STRING)
    private CreditStatut creditStatut;
    private double tauxInteret;

    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "credit")
    private List<Remboursement>  remboursementList;
}

