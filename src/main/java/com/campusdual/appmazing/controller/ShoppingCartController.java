package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.IShoppingCartService;
import com.campusdual.appmazing.model.dto.ContactDto;
import com.campusdual.appmazing.model.dto.ProductDto;
import com.campusdual.appmazing.model.dto.ShoppingCartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

    @Autowired
    private IShoppingCartService shoppingCartService;

    @GetMapping
    public String testController(){
        return "ShoppingCart controller works!";
    }

    @PostMapping
    public String testController(@RequestBody String name){
        return "ShoppingCart controller works, " + name + "!";
    }

    @GetMapping(value = "/getAll")
    public List<ShoppingCartDto> queryAllShoppingCart(){
        return shoppingCartService.queryAllShoppingCart();
    }

    @PostMapping(value = "/addtoshoppingcart")
    public int addToShoppingCart(@RequestBody ShoppingCartDto shoppingCartDto){
        return shoppingCartService.addToShoppingCart(shoppingCartDto);
    }
}
