package tn.esprit.muse.service;

import tn.esprit.muse.entities.*;

import java.util.List;

public interface MuseeImp {
    Musee ajouterMusee(Musee musee);
    Personnel ajouterPersonnel(Personnel personnel);
    public Zone ajouterZoneEtAffecterAMusee (Zone zone, Long idMusee);
    OeuvreArt ajouterOeuvreArtEtAffecterAZone(OeuvreArt oeuvreArt, Long
            idZone);
    void affecterPersonnelsAZone(Long idZone, Long idPersonnel);
    List<String> titreTableauParMuseeEtDirection(Long idMusee, Direction direction) ;
    void desaffecterDirecteursZoneInactif() ;
}
