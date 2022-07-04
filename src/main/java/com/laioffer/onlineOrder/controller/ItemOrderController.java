package com.laioffer.onlineOrder.controller;

import com.laioffer.onlineOrder.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemOrderController {

    @Autowired
    private OrderItemService orderItemService;

    @RequestMapping(value = "/order/{menuId}", method = RequestMethod.POST)
    @ResponseBody
    public void addMenuItemToCart(@PathVariable("menuId") int menuId) {
        orderItemService.saveOrderItem(menuId);
    }
}
