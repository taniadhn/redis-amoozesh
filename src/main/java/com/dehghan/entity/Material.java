package com.dehghan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

/**
 * I want to store Material in Redis
 * **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("Material")
public class Material implements Serializable {

    @Id
    private int id;
    private String name;
    private int quantity;
    private double price;
}
