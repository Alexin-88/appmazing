package com.campusdual.appmazing.model.dto.dtomapper;

import com.campusdual.appmazing.model.Product;
import com.campusdual.appmazing.model.ShoppingCart;
import com.campusdual.appmazing.model.dto.ProductDto;
import com.campusdual.appmazing.model.dto.ShoppingCartDto;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface ShoppingCartMapper {

    ShoppingCartMapper INSTANCE = Mappers.getMapper(ShoppingCartMapper.class);

    ShoppingCartDto toDTO(ShoppingCart shoppingCart);

    List<ShoppingCartDto> toDTOList(List<ShoppingCart> shoppingCart);

    ShoppingCart toEntity(ShoppingCartDto shoppingCartDto);
}
