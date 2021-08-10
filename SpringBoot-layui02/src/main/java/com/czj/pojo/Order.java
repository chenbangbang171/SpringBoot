package com.czj.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private int orderId;
    private String orderstartPosition;
    private String orderEndPosition;
    private String orderContent;
    private int orderKindId;
    private double orderPrice;
    private String orderRequest;
    private int orderFromUserId;
    private int orderToUserId;
    private String orderConcatWay;
    private int orderStatus;
    private String orderNewStatus;

}
