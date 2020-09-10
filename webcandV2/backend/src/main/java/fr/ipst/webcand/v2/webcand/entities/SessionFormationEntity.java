package fr.ipst.webcand.v2.webcand.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sessions_formation")
@Data
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class
        , property = "idSessionFormation", scope = Long.class)
@SQLDelete(sql = "DELETE FROM sessionFormation WHERE id_session_formation = ?")
public class SessionFormationEntity {

    @Id
    @Column(name = "id_session_formation")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSessionFormation;

    @Column(name = "date_debut_Session")
    private String dateDebutSession;

    @Column(name = "date_fin_session")
    private String dateFinSession;

    @ManyToOne
    @JoinColumn(name = "id_formation", nullable=false )
    @JsonIgnoreProperties
    private FormationEntity formationEntity;

    @OneToMany(targetEntity=CandidatureEntity.class, mappedBy = "cSessionFormation")
    @JsonIgnoreProperties
    private Set<CandidatureEntity> candidatures = new HashSet<>();

     /*
    @OneToMany(cascade= CascadeType.ALL)
    @JoinTable( name = "candidature_session_associations",
            joinColumns = @JoinColumn( name = "id_session_formation" ),
            inverseJoinColumns = @JoinColumn( name = "id_candidature"))
    private Set<CandidatureEntity> sessionCandidatures = new HashSet<>();*/

}
