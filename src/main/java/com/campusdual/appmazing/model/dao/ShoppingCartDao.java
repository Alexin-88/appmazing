package com.campusdual.appmazing.model.dao;

import com.campusdual.appmazing.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartDao extends JpaRepository<ShoppingCart, Integer> {
}
