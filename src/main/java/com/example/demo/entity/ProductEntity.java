package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "product_id",nullable = false)
	private String productId;
	@Column(name = "product_name",nullable = false)
	private String productName;
	@Column(name="product_type",nullable = false)
	@Enumerated(EnumType.STRING)
	private ProductType productType;
	@Column(name = "manufacturer_name",nullable = false)
	private String manufacturerName;
	
	
	


}
