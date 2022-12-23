package tn.esprit.muse.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OeuvreArt implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOeuvreArt;
    private String Artiste;
    private String titreTableau;
@ManyToOne
    private Zone zone;
}
