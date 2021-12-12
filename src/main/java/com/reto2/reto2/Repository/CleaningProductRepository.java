package com.reto2.reto2.Repository;

import com.reto2.reto2.Interface.CleaningProductCrudRepository;
import com.reto2.reto2.Models.CleaningProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CleaningProductRepository {
    @Autowired
    private CleaningProductCrudRepository cleaningProductCrudRepository;

    public Optional<CleaningProduct> getProduct(int id){
        return cleaningProductCrudRepository.findById(id);
    }

    public List<CleaningProduct> listar(){
        return cleaningProductCrudRepository.findAll();
    }

    public CleaningProduct create(CleaningProduct product){
        return cleaningProductCrudRepository.save(product);
    }

    public CleaningProduct update(CleaningProduct product){
        return cleaningProductCrudRepository.save(product);
    }

    public void delete(CleaningProduct product){
        cleaningProductCrudRepository.delete(product);
    }

}
