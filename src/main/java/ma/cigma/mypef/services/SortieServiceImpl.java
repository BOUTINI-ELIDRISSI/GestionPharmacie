package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.FactureDto;
import ma.cigma.mypef.dtos.MedicamentDto;
import ma.cigma.mypef.dtos.SortieDto;
import ma.cigma.mypef.dtos.SortieKeyDto;
import ma.cigma.mypef.mapper.Mapper_class;
import ma.cigma.mypef.repositories.SortieRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sortie_service")
public class SortieServiceImpl implements SortieService{
    public SortieRepository repository;
    public Mapper_class mapper= Mappers.getMapper(Mapper_class.class);

    public SortieServiceImpl(@Qualifier("sortie_repo") SortieRepository repository) {
        this.repository = repository;
    }

    @Override
    public Long create(SortieDto dto) {
        return mapper.convertSortieEntitytoDto(repository.save(mapper.convertSortieDtotoEntity(dto))).getId().getFacturecode();
    }

    @Override
    public Long update(SortieDto dto) {
        return mapper.convertSortieEntitytoDto(repository.save(mapper.convertSortieDtotoEntity(dto))).getId().getFacturecode();
    }

    @Override
    public boolean delete(SortieKeyDto key) {
        repository.deleteById(mapper.SortieKeyDtoToEntity(key));
        return true;
    }

    @Override
    public List<SortieDto> readAll() {
        return mapper.convertSortieEntitiestoDtos(repository.findAll());
    }

    @Override
    public List<SortieDto> findByFacture(long factureCode) {
        FactureDto facture = new FactureDto();
        facture.setCode(factureCode);
        return mapper.convertSortieEntitiestoDtos(repository.findByFacture(mapper.convertFactDtotoEntity(facture)));
    }

    @Override
    public List<SortieDto> findByMedicament(long medicamentId) {
        MedicamentDto medicament = new MedicamentDto();
        medicament.setId(medicamentId);
        return mapper.convertSortieEntitiestoDtos(repository.findByMedicament(mapper.convertMedicamentDtotoEntity(medicament)));
    }
}
