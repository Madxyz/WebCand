package fr.ipst.webcand.v2.webcand.controller;

import fr.ipst.webcand.v2.webcand.dto.ProfilDto;
import fr.ipst.webcand.v2.webcand.dto.mapper.IProfilMapper;
import fr.ipst.webcand.v2.webcand.entities.ProfilEntity;
import fr.ipst.webcand.v2.webcand.services.interfaces.IProfilEtCandidatUCService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidats/")
@Tag(name = "Gestion des profils")
public class ProfilEtCandidatUCController {

    @Autowired
    private IProfilEtCandidatUCService pucservice;

    @Autowired
    private IProfilMapper pucmapper;

    @GetMapping("{id}/profils")
    @Operation(summary = "Méthode permettant de voir tous les profils d'un candidat")
    public ResponseEntity<List<ProfilDto>> getAllProfilByIdCandidat(@PathVariable("id") Long id) {
        List<ProfilEntity> profils =  pucservice.getAllProfilByIdCandidat(id);
        List<ProfilDto> profilsDto = pucmapper.listeEntiteVersListeDto(profils);
        return ResponseEntity.ok(profilsDto);
    }

    @GetMapping("{idC}/profils/{idP}")
    @Operation(summary = "Méthode permettant de voir un profil d'un candidat")
    public ResponseEntity<ProfilDto> getOneProfilByIdCandidat(@PathVariable("idC") Long idC,
                                                              @PathVariable("idP") Long idP) {
        ProfilEntity profil = pucservice.getOneProfilByIdCandidat(idC, idP);
        ProfilDto profilDto = pucmapper.entiteVersDto(profil);
        return ResponseEntity.ok(profilDto);


    }

}
