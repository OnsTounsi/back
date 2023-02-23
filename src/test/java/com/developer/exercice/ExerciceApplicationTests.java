package com.developer.exercice;

import com.developer.exercice.entities.Categorie;
import com.developer.exercice.entities.Produit;
import com.developer.exercice.repositories.CategorieRepository;
import com.developer.exercice.repositories.ProduitService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ExerciceApplicationTests {
  @Autowired
  private ProduitService service;

  @Test
  void contextLoads() {
    Optional<Produit> produit = service.findById(8L);
    assertThat(produit).isNotNull();

  }
}
