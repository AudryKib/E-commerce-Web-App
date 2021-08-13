package org.ItSolutions.ecommerceWebApp.dao;

import org.ItSolutions.ecommerceWebApp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
