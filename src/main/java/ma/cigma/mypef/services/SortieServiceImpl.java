package ma.cigma.mypef.services;

import ma.cigma.mypef.dtos.FactureDto;
import ma.cigma.mypef.dtos.MedicamentDto;
import ma.cigma.mypef.dtos.SortieDto;
import ma.cigma.mypef.dtos.SortieKeyDto;
import ma.cigma.mypef.mapper.Mapper_class;
import ma.cigma.mypef.repositories.FactureRepository;
import ma.cigma.mypef.repositories.MedicamentRepository;
import ma.cigma.mypef.repositories.SortieRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sortie_service")
public class SortieServiceImpl implements SortieService{
    public SortieRepository repository;
    public FactureRepository factureRepository;
    public MedicamentRepository medicamentRepository;
    public Mapper_class mapper= Mappers.getMapper(Mapper_class.class);

    public SortieServiceImpl(@Qualifier("sortie_repo") SortieRepository repository,@Qualifier("medicament_repo") MedicamentRepository medicamentRepository,
                             @Qualifier("fact_repo") FactureRepository factureRepository) {
        this.repository = repository;
        this.factureRepository=factureRepository;
        this.medicamentRepository=medicamentRepository;
    }

    //ajoutre vente
    @Override
    public String create(SortieDto dto) {
        boolean exist = false;
        List<SortieDto> lst=mapper.convertSortieEntitiestoDtos(repository.findByMedicament(mapper.convertMedicamentDtotoEntity(dto.getMedicament())));
        for(int i = 0; i < lst.size(); i++){
            if(lst.get(i).getFacture().getCode() == dto.getFacture().getCode())
                exist =true;
        }
        if(!exist){

            mapper.convertSortieEntitytoDto(repository.save(mapper.convertSortieDtotoEntity(dto)));
            return "le médicament a été ajouté à la facture";
        }
        else
            return "Le médicament est déjà à la facture";

      
    }

    @Override
    public String create_table(List<SortieDto> dtos) {
        repository.saveAll(mapper.convertSortieDtostoEntities(dtos));
        return "la facture a été ajouté avec succes";
    }
    // ajouter plusieur vente


    //modifier vente
    @Override
    public String update(SortieDto dto) {
        boolean exist = false;
        List<SortieDto> lst=mapper.convertSortieEntitiestoDtos(repository.findByMedicament(mapper.convertMedicamentDtotoEntity(dto.getMedicament())));
        for(int i = 0; i < lst.size(); i++){
            if(lst.get(i).getFacture().getCode() == dto.getFacture().getCode())
                exist =true;
        }
        if(exist){
            mapper.convertSortieEntitytoDto(repository.save(mapper.convertSortieDtotoEntity(dto)));
            return "le médicament a été modifier à la facture";
        }
        else
            return "Le médicament n'existe pas";
    }
    @Override
    public boolean delete( long code) {
        List<SortieDto> lst = mapper.convertSortieEntitiestoDtos(repository.findByFacture(factureRepository.findByCode(code)));
        if( lst != null) {
            for (int i = 0; i < lst.size(); i++) {
                SortieKeyDto key = new SortieKeyDto(lst.get(i).getMedicament().getId(), code);
                repository.deleteById(mapper.SortieKeyDtoToEntity(key));
            }
        }
        return true;
    }
    //afficher list des ventes
    @Override
    public List<SortieDto> readAll() {
        return mapper.convertSortieEntitiestoDtos(repository.findAll());
    }

    //find by code facture
    @Override
    public List<SortieDto> findByFacture(long factureCode) {
        FactureDto facture = new FactureDto();
        facture.setCode(factureCode);
        return mapper.convertSortieEntitiestoDtos(repository.findByFacture(mapper.convertFactDtotoEntity(facture)));
    }
    //find by libelle de medicament
    @Override
    public List<SortieDto> findByMedicament(String libelle) {
        MedicamentDto medicament = mapper.convertMedicamentEntitytoDto(medicamentRepository.findByLibelle(libelle));
        return mapper.convertSortieEntitiestoDtos(repository.findByMedicament(mapper.convertMedicamentDtotoEntity(medicament)));
    }
}