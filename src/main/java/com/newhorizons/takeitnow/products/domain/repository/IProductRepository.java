package com.newhorizons.takeitnow.products.domain.repository;

import com.newhorizons.takeitnow.products.application.mainmodule.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    List<ProductDto> getAll();
    Optional<ProductDto> getProduct(long productId);
    Optional<ProductDto> save(ProductDto orderDto);
    Optional<ProductDto> modify(ProductDto orderDto);
    void delete(ProductDto orderDto);

}
