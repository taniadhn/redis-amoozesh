package com.dehghan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialPubSub {

    @Id
    private int id;
    private String name;
    private int quantity;
    private double price;
}
