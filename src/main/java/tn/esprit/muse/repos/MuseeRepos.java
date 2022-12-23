package tn.esprit.muse.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.muse.entities.Musee;

@Repository
public interface MuseeRepos extends JpaRepository<Musee,Long> {
}
