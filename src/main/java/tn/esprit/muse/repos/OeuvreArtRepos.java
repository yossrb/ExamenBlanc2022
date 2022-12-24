package tn.esprit.muse.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.muse.entities.Direction;
import tn.esprit.muse.entities.OeuvreArt;

import java.util.List;

@Repository
public interface OeuvreArtRepos extends JpaRepository<OeuvreArt,Long>
         {

             List<OeuvreArt> findByZoneMuseeIdMuseeAndZoneDirection(Long idMusee, Direction direction);
         }
