package tn.esprit.muse.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Zone implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY )
    private Long idZone;
    private String code;
    private  String libelle;
    @Enumerated(EnumType.STRING)
    private Direction direction;
    private  Boolean actif;
    @ManyToOne
    private Musee musee;
    @OneToMany(mappedBy = "zone")
   private  Set<OeuvreArt>oeuvreArts;
@OneToOne
private Personnel directeur;
@OneToMany(mappedBy ="zoneGardien" )
private Set<Personnel>gardiens=new HashSet<>();

}
