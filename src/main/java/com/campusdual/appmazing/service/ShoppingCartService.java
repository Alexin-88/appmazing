package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.IShoppingCartService;
import com.campusdual.appmazing.model.ShoppingCart;
import com.campusdual.appmazing.model.dao.ShoppingCartDao;
import com.campusdual.appmazing.model.dto.ShoppingCartDto;
import com.campusdual.appmazing.model.dto.dtomapper.ShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ShoppingCartService")
@Lazy
public class ShoppingCartService implements IShoppingCartService {

    @Autowired
    private ShoppingCartDao shoppingCartDao;

    @Override
    public ShoppingCartDto queryShoppingCart(ShoppingCartDto shoppingCartDto) {
        ShoppingCart shoppingCart = ShoppingCartMapper.INSTANCE.toEntity(shoppingCartDto);
        return ShoppingCartMapper.INSTANCE.toDTO(shoppingCartDao.getReferenceById(shoppingCart.getId()));
    }

    @Override
    public List<ShoppingCartDto> queryAllShoppingCart() {
        return ShoppingCartMapper.INSTANCE.toDTOList(shoppingCartDao.findAll());
    }

    @Override
    public int insertShoppingCart(ShoppingCartDto shoppingCartDto) {
        ShoppingCart shoppingCart = ShoppingCartMapper.INSTANCE.toEntity(shoppingCartDto);
        shoppingCartDao.saveAndFlush(shoppingCart);
        return shoppingCart.getId();
    }

    @Override
    public int updateShoppingCart(ShoppingCartDto shoppingCartDto) {
        return insertShoppingCart(shoppingCartDto);
    }

    @Override
    public int deleteShoppingCart(ShoppingCartDto shoppingCartDto) {
        ShoppingCart shoppingCart = ShoppingCartMapper.INSTANCE.toEntity(shoppingCartDto);
        shoppingCartDao.delete(shoppingCart);
        return shoppingCart.getId();
    }
}
