package com.example.demo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.ProductEntity;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.repo.ProductRepository;
import com.example.demo.ui.ProductResponseModel;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	private final ModelMapper modelMapper;
	private final ProductRepository productRepository;
	

	

	@Override
	public ProductResponseModel createProduct(ProductDto productDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	       ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
	       return modelMapper.map(productRepository.save(productEntity), ProductResponseModel.class);
	}

	@Override
	public List<ProductResponseModel> getAllProducts() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<ProductResponseModel> userResponseModels = new ArrayList<ProductResponseModel>();
		List<ProductEntity> list = productRepository.findAll();

		Iterator<ProductEntity> i=list.iterator();
		while(i.hasNext())
		{
			ProductResponseModel model= modelMapper.map(i.next(), ProductResponseModel.class);
			userResponseModels.add(model);
		}
		return userResponseModels;
	}

	@Override
	public ProductResponseModel findProductByProductId(String productId) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductEntity productEntity=productRepository.findByProductId(productId);
		if(productEntity==null)
		{
			throw new ProductNotFoundException("product is not found");
		}
		return modelMapper.map(productEntity, ProductResponseModel.class);
	}

	@Override
	public ProductResponseModel updateProduct(ProductDto productDto,String productId) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

		ProductEntity productEntity=productRepository.findByProductId(productId);
		if(productEntity==null)
		{
			throw new ProductNotFoundException("product is not found");
		}else {
			productEntity.setProductId(productId);
			productEntity.setProductName(productDto.getProductName());
			productEntity.setProductType(productDto.getProductType());
			productEntity.setManufacturerName(productDto.getManufacturerName());
			return modelMapper.map(productRepository.save(productEntity), ProductResponseModel.class);
		} 
	
	}

	@Override
	@Transactional
	public ProductResponseModel deleteProduct(String productId) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductEntity productEntity=productRepository.findByProductId(productId);
		if(productEntity==null) {
			throw new ProductNotFoundException();
		}else {
			productRepository.deleteByProductId(productId);
			return modelMapper.map(productEntity,ProductResponseModel.class);
		}
		
		
		
	}
}
