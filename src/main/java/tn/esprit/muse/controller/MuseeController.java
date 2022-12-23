package tn.esprit.muse.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.muse.entities.Direction;
import tn.esprit.muse.entities.Musee;
import tn.esprit.muse.entities.OeuvreArt;
import tn.esprit.muse.entities.Zone;
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
    @GetMapping("/afficherlestitres/{idMusee}")
    List<String> titreTableauParMuseeEtDirection(@PathVariable Long idMusee, Direction direction) {
        return museeImp.titreTableauParMuseeEtDirection(idMusee,direction);
    }
    void desaffecterDirecteursZoneInactif() {
        
    }

}
