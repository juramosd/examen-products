package com.newhorizons.takeitnow.products.infrastructure.crud;

import com.newhorizons.takeitnow.products.domain.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface IProductCrudRepository extends CrudRepository<Product, Long> {
}
