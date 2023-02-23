package com.developer.exercice.repositories;

import com.developer.exercice.entities.Categorie;
import com.developer.exercice.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
  List<Produit> findByCategorie(Categorie categorie);


}
