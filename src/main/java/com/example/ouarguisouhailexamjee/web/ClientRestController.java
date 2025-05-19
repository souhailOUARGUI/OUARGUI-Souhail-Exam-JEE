package com.example.ouarguisouhailexamjee.web;


import com.example.ouarguisouhailexamjee.dtos.ClientDTO;
import com.example.ouarguisouhailexamjee.services.CreditService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j

public class ClientRestController {
private CreditService creditService;


@GetMapping("/clients/{id}")
public ClientDTO getClient(@PathVariable Long id) {
    return creditService.getClient(id);
}

    @GetMapping("/clients")
    public List<ClientDTO> listClients() {
        return creditService.listClients();
    }

    @PostMapping("/clients")
    public ClientDTO saveClient(ClientDTO clientDTO) {
        return creditService.saveClient(clientDTO);
    }


    @PutMapping("/clients/{id}")
    public ClientDTO updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        return creditService.updateClient(clientDTO);
    }


    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Long id) {
        creditService.deleteClient(id);
    }

}
