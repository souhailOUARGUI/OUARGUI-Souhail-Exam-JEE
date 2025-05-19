package com.example.ouarguisouhailexamjee.services;


import com.example.ouarguisouhailexamjee.dtos.*;
import com.example.ouarguisouhailexamjee.enums.BienType;

import java.util.List;

public interface CreditService {
    ClientDTO saveClient(ClientDTO clientDTO);
    List<ClientDTO> listClients();

    CreditImmobilierDTO saveCreditImmobilier(Long clientId, double montant , BienType bienType);
    CreditPersonnelDTO saveCreditPersonnel(Long clientId, double montant, String motif);
    CreditProfessionnelDTO saveCreditProfessionnel(Long clientId, double montant, String motif, String raisonSociale);

    CreditDTO getCreditById(Long creditId);

    ClientDTO getClient(Long clientId);
    ClientDTO updateClient(ClientDTO clientDTO);
    void deleteClient(Long clientId);

    List<RemboursementDTO> remboursementList(Long creditId);


}
