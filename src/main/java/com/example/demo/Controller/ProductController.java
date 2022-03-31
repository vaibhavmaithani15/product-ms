package com.example.demo.Controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ProductDto;
import com.example.demo.service.ProductService;
import com.example.demo.ui.ProductRequestModel;
import com.example.demo.ui.ProductResponseModel;

import lombok.AllArgsConstructor;


@RestController
@AllArgsConstructor
public class ProductController {
	
	private final ModelMapper modelMapper;
	private final ProductService productService;
	private final Environment environment;

	@GetMapping("/status")
	public ResponseEntity<String> getStatus() {
		return ResponseEntity
				.ok("user-service-ws is up and running on port: " + environment.getProperty("local.server.port"));
	}

	@PostMapping("/products")
	public ResponseEntity<ProductResponseModel> createUser(@Validated @Valid @RequestBody ProductRequestModel productDetails) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductDto productDto = modelMapper.map(productDetails, ProductDto.class);
		productDto.setProductId(UUID.randomUUID().toString());
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productDto));
	}

	@GetMapping("/products")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<ProductResponseModel> getAllProducts() {

		return productService.getAllProducts();
	}
	
	@GetMapping("/products/{productId}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public ProductResponseModel findUserByProductId(@PathVariable("productId") String productId)
	{
		return productService.findProductByProductId(productId);
	}
	
	@PutMapping("/products/{productId}")
	public ResponseEntity<ProductResponseModel> updateProduct(@Valid @Validated @PathVariable("productId") String productId,@Validated @Valid @RequestBody ProductRequestModel productDetails) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductDto productDto = modelMapper.map(productDetails, ProductDto.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.updateProduct(productDto, productId));
	}
	
	@DeleteMapping("/products/{productId}")
	@ResponseStatus(code = HttpStatus.OK)
	public ProductResponseModel deleteProduct(@Valid @Validated @PathVariable ("productId") String productId){
		return productService.deleteProduct(productId);
				
		
	}


}
