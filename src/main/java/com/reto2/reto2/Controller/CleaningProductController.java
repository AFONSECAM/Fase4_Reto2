package com.reto2.reto2.Controller;

import com.reto2.reto2.Models.CleaningProduct;
import com.reto2.reto2.Service.CleaningProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/cleaningprod")
public class CleaningProductController {
    @Autowired
    private CleaningProductService cleaningProductService;

    @GetMapping("/all")
    public List<CleaningProduct> listarProductos(){
        return cleaningProductService.listar();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct create(@RequestBody CleaningProduct product){
        return cleaningProductService.create(product);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public CleaningProduct update(@RequestBody CleaningProduct product){
        return cleaningProductService.update(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "id") Integer id){
        cleaningProductService.delete(id);
    }
}
