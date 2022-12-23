package tn.esprit.muse.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Personnel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersonnel;
    private String nom;
    private String prenom;
    private Date DatedernierAffectation;
    @Enumerated(EnumType.STRING)
    private TypePersonnel typePersonnel;
@OneToOne(mappedBy = "directeur")
    private Zone zoneDirecteur;
@ManyToOne
  private  Zone zoneGardien;

}
