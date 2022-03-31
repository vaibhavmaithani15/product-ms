package com.example.demo.ui;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.entity.ProductType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRequestModel {
	@NotNull
	@NotBlank
	@Size(min = 4,max = 255)
	private String productName;
	@NotNull
	private ProductType productType;
	@NotNull
	@NotBlank
	@Size(min = 4,max = 255)
	private String manufacturerName;

}
