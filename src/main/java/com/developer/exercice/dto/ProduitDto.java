package com.developer.exercice.dto;


import com.developer.exercice.entities.Produit;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Builder
@Data
public class ProduitDto {

    private Long id;

    private CategorieDto cat;

    private String nom;

    private int quantite;

    private Boolean disponible;

    private LocalDate dateCreation;

    private LocalDate dateModif;

    public ProduitDto fromEntity(Produit produit){
        if(produit == null){
            return null;
        }
        return ProduitDto.builder()
                .id(produit.getId())
                .nom(produit.getNom())
                .quantite(produit.getQuantite())
                .disponible(produit.getDisponible())
                .dateCreation(produit.getDateCreation())
                .dateModif(produit.getDateModif())
                .build();

    }

    public Produit toEntity(ProduitDto produitDto){
        if(produitDto == null){
            return null;
        }
        Produit produit = new Produit();
        produit.setId(produitDto.getId());
        produit.setNom(produitDto.getNom());
        produit.setQuantite(produitDto.getQuantite());
        produit.setDisponible(produitDto.getDisponible());
        produit.setDateCreation(produitDto.getDateCreation());
        produit.setDateModif(produitDto.getDateModif());
        return produit;
    }
}
