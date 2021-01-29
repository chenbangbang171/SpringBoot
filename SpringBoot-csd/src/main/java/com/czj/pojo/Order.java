package com.czj.pojo;

import lombok.Data;

@Data
public class Order {
    private int orderId;
    private int carId;
    private int userId;
    private int getId;
    private int backId;
    private double oprice;
    private String status;
}
