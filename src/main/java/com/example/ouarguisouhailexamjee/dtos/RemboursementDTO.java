package com.example.ouarguisouhailexamjee.dtos;


import com.example.ouarguisouhailexamjee.enums.RemboursementType;
import lombok.Data;

@Data
public class RemboursementDTO {
    private Long id;
    private Double montant;
    private String dateRemboursement;
    private RemboursementType remboursementType;
}
