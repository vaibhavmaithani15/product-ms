package com.example.demo.ui;

import com.example.demo.entity.ProductType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductResponseModel {

	private String productId;
	private String productName;
	private ProductType productType;
	private String manufacturerName;
}
