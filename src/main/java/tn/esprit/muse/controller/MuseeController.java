package tn.esprit.muse.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.muse.entities.*;
import tn.esprit.muse.service.MuseeImp;

import java.util.List;

@RestController
@AllArgsConstructor

public class MuseeController {
    private MuseeImp museeImp;


    @PostMapping("/ajoutmusee")
    Musee ajouterMusee(@RequestBody Musee musee){
        return museeImp.ajouterMusee(musee);
    }
    @PostMapping("/ajoutpersoo")
    Personnel ajouterPersonnel(@RequestBody Personnel personnel){
        return museeImp.ajouterPersonnel(personnel);
    }
        @PostMapping("/ajoutzone/{idMusee}")
        public Zone ajouterZoneEtAffecterAMusee (@RequestBody Zone zone, @PathVariable Long idMusee){
            return museeImp.ajouterZoneEtAffecterAMusee(zone,idMusee);

        }
        @PostMapping("/ajoutoeuvre/{idZone}")
    OeuvreArt ajouterOeuvreArtEtAffecterAZone(@RequestBody OeuvreArt oeuvreArt, @PathVariable Long idZone){
        return museeImp.ajouterOeuvreArtEtAffecterAZone(oeuvreArt,idZone);
    }
    @PostMapping("/affecterpersonnel/{idZone}/{idPersonnel}")
    void affecterPersonnelsAZone(Long idZone, Long idPersonnel){
         museeImp.affecterPersonnelsAZone(idZone,idPersonnel);
    }
    @GetMapping("/afficherlestitres/{idMusee}/{direction}")
    List<String> titreTableauParMuseeEtDirection(@PathVariable Long idMusee, @PathVariable Direction direction) {
        return museeImp.titreTableauParMuseeEtDirection(idMusee,direction);
    }


}
