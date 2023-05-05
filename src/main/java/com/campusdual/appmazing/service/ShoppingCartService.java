package com.campusdual.appmazing.service;

import com.campusdual.appmazing.api.IShoppingCartService;
import com.campusdual.appmazing.model.ShoppingCart;
import com.campusdual.appmazing.model.dao.ContactDao;
import com.campusdual.appmazing.model.dao.ProductDao;
import com.campusdual.appmazing.model.dao.ShoppingCartDao;
import com.campusdual.appmazing.model.dto.ContactDto;
import com.campusdual.appmazing.model.dto.ProductDto;
import com.campusdual.appmazing.model.dto.ShoppingCartDto;
import com.campusdual.appmazing.model.dto.dtomapper.ContactMapper;
import com.campusdual.appmazing.model.dto.dtomapper.ProductMapper;
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

    @Autowired
    private ContactDao contactDao;

    @Autowired
    private ProductDao productDao;

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

    @Override
    public int addToShoppingCart(ShoppingCartDto shoppingCartDto) {
        ProductDto productBBDD = ProductMapper.INSTANCE.toDTO(productDao.getReferenceById(shoppingCartDto.getIdproduct()));
        ContactDto contactBBDD = ContactMapper.INSTANCE.toDTO(contactDao.getReferenceById(shoppingCartDto.getIdcontact()));

        if (contactBBDD != null){
            if (productBBDD != null){
                if (productBBDD.getStock() > shoppingCartDto.getAmount()){
                    //Actualizamos el valor del stock y un update con los nuevos datos del producto
                    productBBDD.setStock(productBBDD.getStock()-shoppingCartDto.getAmount());
                    productDao.saveAndFlush(ProductMapper.INSTANCE.toEntity(productBBDD));
                    //Insertamos datos del ShopingCart
                    return insertShoppingCart(shoppingCartDto);
                }
            }
        }
        return -1;
    }
}
