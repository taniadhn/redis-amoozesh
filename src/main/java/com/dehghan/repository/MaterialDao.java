package com.dehghan.repository;

import com.dehghan.entity.Material;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MaterialDao {

    public static final String HASH_KEY = "Material";
    private RedisTemplate  redisTemplate;

    public MaterialDao(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    public Material save(Material material){
        redisTemplate.opsForHash().put(HASH_KEY,material.getId(),material);
        return  material;
    }

    public List<Material> findAll(){
        return  redisTemplate.opsForHash().values(HASH_KEY);
    }

    public Material findById(int id){
        System.out.println("call findById() from DB");
        return (Material) redisTemplate.opsForHash().get(HASH_KEY,id);
    }

    public String deleteProduct(int id){
          redisTemplate.opsForHash().delete(HASH_KEY,id);
          return "Product deleted!!!";
    }
}
