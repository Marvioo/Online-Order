package com.laioffer.onlineOrder.controller;

import com.laioffer.onlineOrder.entity.Cart;
import com.laioffer.onlineOrder.entity.OrderItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    @ResponseBody
    public Cart getCart() {
        return new Cart();
    }
}
