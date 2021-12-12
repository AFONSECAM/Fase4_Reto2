package com.reto2.reto2.Interface;

import com.reto2.reto2.Models.CleaningProduct;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CleaningProductCrudRepository extends MongoRepository<CleaningProduct, Integer> {
}
