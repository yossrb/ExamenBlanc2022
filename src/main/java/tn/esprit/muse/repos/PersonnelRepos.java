package tn.esprit.muse.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.muse.entities.Personnel;

@Repository
public interface PersonnelRepos extends JpaRepository<Personnel,Long> {
}
