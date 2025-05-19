package com.example.ouarguisouhailexamjee.web;


import com.example.ouarguisouhailexamjee.dtos.ClientDTO;
import com.example.ouarguisouhailexamjee.dtos.CreditDTO;
import com.example.ouarguisouhailexamjee.dtos.RemboursementDTO;
import com.example.ouarguisouhailexamjee.services.CreditService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class CreditRestApi {
    private CreditService creditService;

    @GetMapping("/credits/{id}")
    public CreditDTO getCredit(@PathVariable Long id) {
       return   creditService.getCreditById(id);
    }

    @GetMapping("/credits")
    public List<CreditDTO> listCredits() {
        return creditService.listCredits();
    }


    @GetMapping("/credits/{creditId}/remboursements")
    public List<RemboursementDTO> remboursementList(@PathVariable Long creditId) {
        return creditService.remboursementList(creditId);
    }



}
