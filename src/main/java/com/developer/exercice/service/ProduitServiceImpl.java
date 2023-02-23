package com.developer.exercice.service;

import com.developer.exercice.entities.Categorie;
import com.developer.exercice.entities.Produit;
import com.developer.exercice.repositories.CategorieService;
import com.developer.exercice.repositories.ProduitRepository;
import com.developer.exercice.repositories.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements ProduitService {
  @Autowired
  private ProduitRepository produitRepository;
  @Autowired
  private CategorieService categorieService;
  @Override
  public Optional<Produit> findById(Long id) {

      return produitRepository.findById(id);
  }
  @Override
  public List<Produit> findAll(){

      return produitRepository.findAll();
  }
  @Override
  public List<Produit> afficherProduitByCategorie(Long idCategorie) {
    Categorie categorie = categorieService.findById(idCategorie).get();
    return produitRepository.findByCategorie(categorie);
  }

    public Produit create (Produit produit , long id){

      produit.getCategorie();

      Categorie categorie = categorieService.findById(id).orElse(null);
      produit.setCategorie(categorie);
      LocalDate date = LocalDate.now();
      produit.setDateCreation(date);


      return produitRepository.save(produit);
    }
    @Override
    public boolean supprimer(Long id) {

      produitRepository.deleteById(id);
        return true;
      }

      public Produit modif(Long id, Produit produit,Long idCat) {
        produit.getCategorie();
        Categorie categorie = categorieService.findById(idCat).orElse(null);
        produit.setCategorie(categorie);
          Produit existingProduct = produitRepository.findById(id).orElse(null);
          if (existingProduct != null) {
              existingProduct.setNom(produit.getNom());
              existingProduct.setCategorie(produit.getCategorie());
              existingProduct.setQuantite(produit.getQuantite());
              existingProduct.setDisponible(produit.getDisponible());
              existingProduct.setDateModif(LocalDate.now());

              return produitRepository.save(existingProduct);
          }
          return null;
      }
}
