package com.developer.exercice.service;

import com.developer.exercice.controllers.ProduitController;
import com.developer.exercice.entities.Categorie;
import com.developer.exercice.entities.Produit;
import com.developer.exercice.repositories.CategorieRepository;
import com.developer.exercice.repositories.CategorieService;
import com.developer.exercice.repositories.ProduitRepository;
import com.developer.exercice.repositories.ProduitService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProduitServiceImplTest {

    @Autowired
    private ProduitService service;
    @Autowired
    ProduitController produitController;
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private ProduitRepository produitRepository;
    @Test
    public void testGetProduit(){
      Optional<Produit> produit = service.findById(8L);
      assertThat(produit).isNotNull();
    }
    @Test
    public void findAllTest(){
      List<Produit> produit =service.findAll();
      assertThat(produit).isNotNull();
    }
    @Test
    public void SaveProduitSucces(){
        Categorie category = categorieRepository.findById(2L).orElse(null);
        assertNotNull(category);
        Produit expectedProduit = Produit.builder()
                .nom("aaa")
                .quantite(41)
                .disponible(false)
                .categorie(category)
                .build();
        Produit savedProduit = service.create(expectedProduit,category.getId());
        assertNotNull(savedProduit);
        assertNotNull(savedProduit.getId());
        assertNotNull(expectedProduit.getQuantite() , String.valueOf(savedProduit.getQuantite()));
        assertNotNull(expectedProduit.getNom() , savedProduit.getNom());
    }
    @Test
    public void UpdateProduitSucces(){
        Categorie category = categorieRepository.findById(1L).orElse(null);
        assertNotNull(category);
        Produit produit = produitRepository.findById(16L).orElse(null);
        assertNotNull(produit);
        produit.setNom("ecran");
        produit.setDisponible(true);
        produit.setCategorie(category);
        produit.setQuantite(140);
        Produit savedProd=service.create(produit,category.getId());

        Produit upadateProduit = savedProd;
        savedProd = service.modif(savedProd.getId(), upadateProduit,category.getId());


        assertNotNull(upadateProduit);
        assertNotNull(upadateProduit.getId());
        assertNotNull(upadateProduit.getQuantite() , String.valueOf(savedProd.getQuantite()));
        assertNotNull(upadateProduit.getNom() , savedProd.getNom());
    }
    @Test
    public void DeleteProduitSucces(){

      Produit produit = new Produit();
      Categorie categorie = new Categorie();
      categorie.setNom("Test");

      Categorie savedCategorie = categorieService.ajout(categorie);
      produit.setNom("produit test");
      produit.setDisponible(true);
      produit.setCategorie(savedCategorie);
      produit.setQuantite(10);
      Long categorieId = savedCategorie.getId();
      produit = service.create(produit,categorieId);
      boolean isDeleted = service.supprimer(produit.getId());
      assertTrue(isDeleted);
      Optional<Produit> optionalProduit = produitRepository.findById(produit.getId());
      assertFalse(optionalProduit.isPresent());
    }
}

