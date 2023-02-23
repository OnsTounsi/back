package com.developer.exercice.repositories;

import com.developer.exercice.entities.Produit;
import java.util.List;
import java.util.Optional;

public interface ProduitService {
  List<Produit> afficherProduitByCategorie(Long idCategorie);

    Produit create (Produit produit , long id);
     List<Produit> findAll();
    Optional<Produit> findById(Long id);

    boolean supprimer(Long id);

    Produit modif(Long id, Produit produit,Long idCat);



}
