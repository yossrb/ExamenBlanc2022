package tn.esprit.muse.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.muse.entities.Zone;

import java.util.List;

@Repository
public interface ZoneRepos extends JpaRepository<Zone,Long> {

    List<Zone> findByActif(boolean actif);
}
