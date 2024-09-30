package com.danielremsburg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.beans.factory.annotation.Value;



@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.danielremsburg.MenuMakerBackend.features.requisitions.repositories",
                                       "com.danielremsburg.MenuMakerBackend.features.menus.repositories"})
 
public class  MenuMaker {

  @Value("${NAME: there}")
  String name;


  
  public static void main(String[] args) {
    SpringApplication.run(MenuMaker.class, args);
  }

}
