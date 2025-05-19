package com.example.ouarguisouhailexamjee.entities;

import com.example.ouarguisouhailexamjee.enums.RemboursementType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Remboursement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double montant;
    private String dateRemboursement;
    private RemboursementType remboursementType;
    @ManyToOne
    private Credit credit;
}
