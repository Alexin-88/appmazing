package com.campusdual.appmazing.controller;

import com.campusdual.appmazing.api.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

}
