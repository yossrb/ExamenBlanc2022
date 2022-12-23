package tn.esprit.muse.service;

import tn.esprit.muse.entities.Direction;
import tn.esprit.muse.entities.Musee;
import tn.esprit.muse.entities.OeuvreArt;
import tn.esprit.muse.entities.Zone;

import java.util.List;

public interface MuseeImp {
    Musee ajouterMusee(Musee musee);
    public Zone ajouterZoneEtAffecterAMusee (Zone zone, Long idMusee);
    OeuvreArt ajouterOeuvreArtEtAffecterAZone(OeuvreArt oeuvreArt, Long
            idZone);
    void affecterPersonnelsAZone(Long idZone, Long idPersonnel);
    List<String> titreTableauParMuseeEtDirection(Long idMusee, Direction direction) ;
    void desaffecterDirecteursZoneInactif() ;
}
