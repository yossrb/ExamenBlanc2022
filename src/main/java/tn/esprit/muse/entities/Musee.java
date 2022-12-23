package tn.esprit.muse.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Musee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idMusee;

    private Date dateInaugration;
    private String designation;
    private String adresse;
    @OneToMany(mappedBy = "musee")
    @JsonIgnore
   private  Set<Zone>zones=new HashSet<>();

}
