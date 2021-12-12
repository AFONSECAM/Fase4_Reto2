package com.reto2.reto2.Service;

import com.reto2.reto2.Models.CleaningProduct;
import com.reto2.reto2.Repository.CleaningProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CleaningProductService {
    @Autowired
    private CleaningProductRepository cleaningProductRepository;

    public List<CleaningProduct> listar(){
        return cleaningProductRepository.listar();
    }

    public CleaningProduct create(CleaningProduct product){
        if(product.getId() == null){
            return product;
        }else{
            Optional<CleaningProduct> oproduct = cleaningProductRepository.getProduct(product.getId());
            if (oproduct.isEmpty()){
                return cleaningProductRepository.create(product);
            }else{
                return product;
            }
        }
    }

    public CleaningProduct update(CleaningProduct product){
        if(product.getId() != null){
            Optional<CleaningProduct> oproduct = cleaningProductRepository.getProduct(product.getId());
            if(!oproduct.isEmpty()){
                if(product.getBrand() != null){
                    oproduct.get().setBrand(product.getBrand());
                }
                if(product.getCategory() != null){
                    oproduct.get().setCategory(product.getCategory());
                }
                if(product.getPresentation() != null){
                    oproduct.get().setPresentation(product.getPresentation());
                }
                if (product.getDescription() != null){
                    oproduct.get().setDescription((product.getDescription()));
                }
                if(product.getPrice() != 0.0){
                    oproduct.get().setPrice(product.getPrice());
                }
                if(product.getQuantity() != 0){
                    oproduct.get().setQuantity(product.getQuantity());
                }
                if (product.getPhotography() != null){
                    oproduct.get().setPhotography(product.getPhotography());
                }
                oproduct.get().setAvailability(product.isAvailability());
                cleaningProductRepository.update(oproduct.get());
                return oproduct.get();
            }else {
                return product;
            }
        }else {
            return product;
        }
    }

    public boolean delete(Integer id){
        Boolean aBoolean = cleaningProductRepository.getProduct(id).map(product -> {
            cleaningProductRepository.delete(product);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
