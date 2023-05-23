package ma.cigma.mypef.mapper;

import ma.cigma.mypef.dtos.*;
import ma.cigma.mypef.entities.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface Mapper_class {

    //Client
    ClientEntity convertClientDtotoEntity(ClientDto dto);
    ClientDto convertClientEntitytoDto(ClientEntity entity);
    List<ClientDto> convertClientEntitiestoDtos(List<ClientEntity> entities);

    //Commande
    CommandeEntity convertCmdDtotoEntity(CommandeDto dto);
    CommandeDto convertCmdEntitytoDto(CommandeEntity entity);
    List<CommandeDto> convertCmdEntitiestoDtos(List<CommandeEntity> entities);

    //Entree
    EntreeEntity convertEntreeDtotoEntity(EntreeDto dto);
    EntreeDto convertEntreeEntitytoDto(EntreeEntity entity);
    List<EntreeDto> convertEntreeEntitiestoDtos(List<EntreeEntity> entities);

    //Facture
    FactureEntity convertFactDtotoEntity(FactureDto dto);
    FactureDto convertFactEntitytoDto(FactureEntity entity);
    List<FactureDto> convertFactEntitiestoDtos(List<FactureEntity> entities);

    //Fournisseur
    FournisseurEntity convertFournisseurDtotoEntity(FournisseurDto dto);
    FournisseurDto convertFournisseurEntitytoDto(FournisseurEntity entity);
    List<FournisseurDto> convertFournisseurEntitiestoDtos(List<FournisseurEntity> entities);

    //Ligne
    LigneEntity convertLigneDtotoEntity(LigneDto dto);
    LigneDto convertLigneEntitytoDto(LigneEntity entity);
    List<LigneDto> convertLigneEntitiestoDtos(List<LigneEntity> entities);
    LigneKeyEntity LigneKeyDtoToEntity(LigneKeyDto cleDto);

    //Medicament
    MedicamentEntity convertMedicamentDtotoEntity(MedicamentDto dto);
    MedicamentDto convertMedicamentEntitytoDto(MedicamentEntity entity);
    List<MedicamentDto> convertMedicamentEntitiestoDtos(List<MedicamentEntity> entities);

    //Role
    RoleEntity convertRoleDtotoEntity(RoleDto dto);
    RoleDto convertRoleEntitytoDto(RoleEntity entity);
    List<RoleDto> convertRoleEntitiestoDtos(List<RoleEntity> entities);

    //Sortie
    SortieEntity convertSortieDtotoEntity(SortieDto dto);
    SortieDto convertSortieEntitytoDto(SortieEntity entity);
    List<SortieDto> convertSortieEntitiestoDtos(List<SortieEntity> entities);
    SortieKeyEntity SortieKeyDtoToEntity(SortieKeyDto cleDto);


    //Utilisateur
    UtilisateurEntity convertUserDtotoEntity(UtilisateurDto dto);
    UtilisateurDto convertUserEntitytoDto(UtilisateurEntity entity);
    List<UtilisateurDto> convertUserEntitiestoDtos(List<UtilisateurEntity> entities);
}
