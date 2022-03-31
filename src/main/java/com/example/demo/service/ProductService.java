package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ProductDto;
import com.example.demo.ui.ProductResponseModel;


public interface ProductService {

	public ProductResponseModel createProduct(ProductDto productDto);

	public List<ProductResponseModel> getAllProducts();

	public ProductResponseModel findProductByProductId(String productId);

	public ProductResponseModel updateProduct(ProductDto productDto, String productId);

	public ProductResponseModel deleteProduct(String productId);

}
