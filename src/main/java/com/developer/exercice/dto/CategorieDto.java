package com.developer.exercice.dto;

import com.developer.exercice.entities.Categorie;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Builder
@Data
public class CategorieDto {

    private Long id;

    private String nom;

    private int quantite;

    private LocalDate dateCreation;

    private LocalDate dateModif;

    private List<ProduitDto> produit;

    public CategorieDto fromEntity(Categorie categorie){
        if(categorie == null){
            return null;
        }
        return CategorieDto.builder()
                .id(categorie.getId())
                .nom(categorie.getNom())
                .quantite(categorie.getQuantite())
                .dateCreation(categorie.getDateCreation())
                .dateModif(categorie.getDateModif())
                .build();

    }

    public Categorie toEntity(CategorieDto categorieDto){
        if(categorieDto == null){
            return null;
        }
        Categorie categorie = new Categorie();
        categorie.setId(categorieDto.getId());
        categorie.setNom(categorieDto.getNom());
        categorie.setQuantite(categorieDto.getQuantite());
        categorie.setDateCreation(categorieDto.getDateCreation());
        categorie.setDateModif(categorieDto.getDateModif());
        return categorie;
    }

}
