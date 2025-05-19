package com.example.ouarguisouhailexamjee.repositories;

import com.example.ouarguisouhailexamjee.entities.Credit;
import com.example.ouarguisouhailexamjee.entities.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditRepository extends JpaRepository<Credit, Long> {

}
