package com.developer.exercice.repositories;

import com.developer.exercice.entities.Categorie;
import java.util.List;
import java.util.Optional;

public interface CategorieService {
    List<Categorie> findAll();

    Optional<Categorie> findById(Long id);
    Categorie ajout(Categorie c);
    boolean supprimer(Long id);

    Categorie modif(Long id,Categorie c);

}
