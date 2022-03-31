package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ProductEntity;
@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String>{
	
	@Query
	public ProductEntity findByProductId(String productId);
	

	@Modifying
	@Query("delete from ProductEntity b where b.productId=:productId")
	void deleteByProductId(@Param("productId") String productId);


}
