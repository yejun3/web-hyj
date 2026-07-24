package com.korea.product.vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderVO {
	private int orderId;
	private int productId;
	private String productName;
	private int productCount;
	private int productPrice; 
	private int totalPrice;
	private LocalDateTime orderDate;
}
