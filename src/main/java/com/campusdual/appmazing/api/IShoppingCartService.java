package com.campusdual.appmazing.api;

import com.campusdual.appmazing.model.dto.ProductDto;
import com.campusdual.appmazing.model.dto.ShoppingCartDto;

import java.util.List;

public interface IShoppingCartService{

    ShoppingCartDto queryShoppingCart(ShoppingCartDto shoppingCartDto);

    List<ShoppingCartDto> queryAllShoppingCart();

    int insertShoppingCart(ShoppingCartDto shoppingCartDto);

    int updateShoppingCart(ShoppingCartDto shoppingCartDto);

    int deleteShoppingCart(ShoppingCartDto shoppingCartDto);
}
