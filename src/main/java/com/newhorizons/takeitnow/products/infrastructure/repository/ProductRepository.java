package com.newhorizons.takeitnow.products.infrastructure.repository;

import com.newhorizons.takeitnow.products.application.mainmodule.dto.ProductDto;
import com.newhorizons.takeitnow.products.application.mainmodule.mapper.IProductMapper;
import com.newhorizons.takeitnow.products.domain.entity.Product;
import com.newhorizons.takeitnow.products.domain.repository.IProductRepository;
import com.newhorizons.takeitnow.products.infrastructure.crud.IProductCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public class ProductRepository implements IProductRepository {

    @Autowired
    private IProductCrudRepository productCrudRepository;

    @Autowired
    private IProductMapper productMapper;

    public List<ProductDto> getAll(){
        List<Product> products = (List<Product>)productCrudRepository.findAll();
        return productMapper.toProductsDto(products);
    }

    public Optional<ProductDto> getProduct(long id){
        return productCrudRepository.findById(id).map(e -> productMapper.toProductDto(e));
    }

    @Override
    public Optional<ProductDto> save(ProductDto orderDto) {
        Product order = productMapper.toProduct(orderDto);
        order.setCreateAt(new Date());
        order = productCrudRepository.save(order);
        return Optional.ofNullable(productMapper.toProductDto(order));
    }

    @Override
    public Optional<ProductDto> modify(ProductDto orderDto) {
        Product order = productMapper.toProduct(orderDto);
        order = productCrudRepository.save(order);
        return Optional.ofNullable(productMapper.toProductDto(order));
    }

    @Override
    public void delete(ProductDto orderDto) {
        Product order = productMapper.toProduct(orderDto);
        productCrudRepository.delete(order);
    }
}
