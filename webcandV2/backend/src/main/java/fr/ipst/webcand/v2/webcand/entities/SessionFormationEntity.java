package fr.ipst.webcand.v2.webcand.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sessions_formation")
@Data
@EqualsAndHashCode(exclude = {"candidatures","formation"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class
        , property = "idSessionFormation", scope = SessionFormationEntity.class)
public class SessionFormationEntity {

    @Id
    @Column(name = "id_session_formation")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSessionFormation;

    @Column(name = "date_debut_Session")
    private String dateDebutSession;

    @Column(name = "date_fin_session")
    private String dateFinSession;


                            /* Table d'associations et relations */
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(referencedColumnName ="id_formation",name = "id_formation", nullable=false )
    @JsonIgnore
    private FormationEntity formation;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinTable( name = "candidature_session_associations",
            joinColumns = @JoinColumn( name = "id_session_formation" ),
            inverseJoinColumns = @JoinColumn( name = "id_candidature"))
    private Set<CandidatureEntity> candidatures = new HashSet<>();


}
