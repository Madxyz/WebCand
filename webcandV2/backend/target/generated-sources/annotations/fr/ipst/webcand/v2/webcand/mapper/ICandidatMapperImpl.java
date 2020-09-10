package fr.ipst.webcand.v2.webcand.mapper;

import fr.ipst.webcand.v2.webcand.dto.CandidatDto;
import fr.ipst.webcand.v2.webcand.entities.CandidatEntity;
import fr.ipst.webcand.v2.webcand.entities.CandidatureEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-09-11T00:10:46+0200",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class ICandidatMapperImpl implements ICandidatMapper {

    @Override
    public CandidatDto entiteVersDto(CandidatEntity candidatEntity) {
        if ( candidatEntity == null ) {
            return null;
        }

        CandidatDto candidatDto = new CandidatDto();

        candidatDto.setIdCandidat( candidatEntity.getIdCandidat() );
        candidatDto.setNomCandidat( candidatEntity.getNomCandidat() );
        candidatDto.setPrenomCandidat( candidatEntity.getPrenomCandidat() );
        candidatDto.setDateNaissanceCandidat( candidatEntity.getDateNaissanceCandidat() );
        candidatDto.setAdresseCandidat( candidatEntity.getAdresseCandidat() );
        candidatDto.setCodePostalCandidat( candidatEntity.getCodePostalCandidat() );
        candidatDto.setVilleCandidat( candidatEntity.getVilleCandidat() );
        candidatDto.setPaysCandidat( candidatEntity.getPaysCandidat() );
        candidatDto.setTelephoneCandidat( candidatEntity.getTelephoneCandidat() );
        List<CandidatureEntity> list = candidatEntity.getCCandidatures();
        if ( list != null ) {
            candidatDto.setCCandidatures( new ArrayList<CandidatureEntity>( list ) );
        }
        else {
            candidatDto.setCCandidatures( null );
        }

        return candidatDto;
    }

    @Override
    public CandidatEntity dtoVersEntite(CandidatDto candidatDto) {
        if ( candidatDto == null ) {
            return null;
        }

        CandidatEntity candidatEntity = new CandidatEntity();

        candidatEntity.setIdCandidat( candidatDto.getIdCandidat() );
        candidatEntity.setNomCandidat( candidatDto.getNomCandidat() );
        candidatEntity.setPrenomCandidat( candidatDto.getPrenomCandidat() );
        candidatEntity.setDateNaissanceCandidat( candidatDto.getDateNaissanceCandidat() );
        candidatEntity.setAdresseCandidat( candidatDto.getAdresseCandidat() );
        candidatEntity.setCodePostalCandidat( candidatDto.getCodePostalCandidat() );
        candidatEntity.setVilleCandidat( candidatDto.getVilleCandidat() );
        candidatEntity.setPaysCandidat( candidatDto.getPaysCandidat() );
        candidatEntity.setTelephoneCandidat( candidatDto.getTelephoneCandidat() );
        List<CandidatureEntity> list = candidatDto.getCCandidatures();
        if ( list != null ) {
            candidatEntity.setCCandidatures( new ArrayList<CandidatureEntity>( list ) );
        }
        else {
            candidatEntity.setCCandidatures( null );
        }

        return candidatEntity;
    }

    @Override
    public List<CandidatDto> listeEntiteVersListeDto(List<CandidatEntity> candidatEntities) {
        if ( candidatEntities == null ) {
            return null;
        }

        List<CandidatDto> list = new ArrayList<CandidatDto>( candidatEntities.size() );
        for ( CandidatEntity candidatEntity : candidatEntities ) {
            list.add( entiteVersDto( candidatEntity ) );
        }

        return list;
    }
}
