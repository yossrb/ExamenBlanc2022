package tn.esprit.muse.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.muse.entities.*;
import tn.esprit.muse.repos.MuseeRepos;
import tn.esprit.muse.repos.OeuvreArtRepos;
import tn.esprit.muse.repos.PersonnelRepos;
import tn.esprit.muse.repos.ZoneRepos;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MuseeService implements MuseeImp {
    private MuseeRepos museeRepos;
    private ZoneRepos zoneRepos;
    private OeuvreArtRepos oeuvreArtRepos;
    private PersonnelRepos personnelRepos;

    @Override
    public Musee ajouterMusee(Musee musee) {
        return museeRepos.save(musee);
    }
    @Override
    public Personnel ajouterPersonnel(Personnel personnel) {
        return personnelRepos.save(personnel);
    }

    @Override
    public Zone ajouterZoneEtAffecterAMusee(Zone zone, Long idMusee) {
        Musee musee = museeRepos.findById(idMusee).orElse(null);
        zone.setMusee(musee);
        return zoneRepos.save(zone);
    }

    @Override
    public OeuvreArt ajouterOeuvreArtEtAffecterAZone(OeuvreArt oeuvreArt, Long idZone) {
        Zone zone = zoneRepos.findById(idZone).orElse(null);
        oeuvreArt.setZone(zone);

        return oeuvreArtRepos.save(oeuvreArt);
    }

    @Override
    public void affecterPersonnelsAZone(Long idZone, Long idPersonnel) {
        Zone zone = zoneRepos.findById(idZone).orElse(null);
        Personnel personnel = personnelRepos.findById(idPersonnel).orElse(null);
        if (personnel.getTypePersonnel() == TypePersonnel.GARDIEN) {
            personnel.setZoneGardien(zone);
            personnelRepos.save(personnel);

        } else {
            zone.setDirecteur(personnel);
            personnelRepos.save(personnel);
        }
    }

    @Override
    public List<String> titreTableauParMuseeEtDirection(Long idMusee, Direction direction) {
        List<String> titreTableau = new ArrayList<>();
        for (OeuvreArt oeuvreArt : oeuvreArtRepos.findByZoneMuseeIdMuseeAndZoneDirection(idMusee, direction)) {
            titreTableau.add(oeuvreArt.getTitreTableau());
        }

        return titreTableau;
    }

@Scheduled(cron = "*/60 * * * * *")
    public void desaffecterDirecteursZoneInactif() {
List<Zone>zones=zoneRepos.findByActif(false);
for (Zone zone:zones){
    zone.setDirecteur(null);
}
    }
}