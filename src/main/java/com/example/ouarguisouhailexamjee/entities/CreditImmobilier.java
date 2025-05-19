package com.example.ouarguisouhailexamjee.entities;


import com.example.ouarguisouhailexamjee.enums.BienType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CIMM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditImmobilier extends Credit{
    private BienType bienType;
}
