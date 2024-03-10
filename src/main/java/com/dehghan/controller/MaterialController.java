package com.dehghan.controller;

import com.dehghan.entity.Material;
import com.dehghan.repository.MaterialDao;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
///Implementing Caching mechanism
@EnableCaching
public class MaterialController {

    private MaterialDao materialDao;

    public  MaterialController (MaterialDao materialDao){
        this.materialDao = materialDao;
    }

    @PostMapping
    public Material save(@RequestBody Material material){
       return materialDao.save(material);
    }

    @GetMapping
    public List<Material> findAll(){
        return materialDao.findAll();
    }
    @GetMapping("/{id}")
    @Cacheable(key = "#id",value = "Material", unless = "#result.price >1000")
    public Material findById(@PathVariable int id){
        return materialDao.findById(id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id",value = "Material")
    public String delete(@PathVariable int id){
         materialDao.deleteProduct(id);
         return "deleted";
    }
}
