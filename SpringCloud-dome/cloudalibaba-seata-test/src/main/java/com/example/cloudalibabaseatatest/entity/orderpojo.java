package com.example.cloudalibabaseatatest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class orderpojo {

    int id;
    int userId;
    int productId;
    int totalAmount;
    int status;

}
