package com.laioffer.onlineOrder.service;

import com.laioffer.onlineOrder.dao.OrderItemDao;
import com.laioffer.onlineOrder.entity.Customer;
import com.laioffer.onlineOrder.entity.MenuItem;
import com.laioffer.onlineOrder.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private MenuInfoService menuInfoService;

    public void saveOrderItem(int menuId) {
        final OrderItem orderItem = new OrderItem();
        final MenuItem menuItem = menuInfoService.getMenuItem(menuId);

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        Customer customer = customerService.getCustomer(username);

        orderItem.setPrice(menuItem.getPrice());
        orderItem.setQuantity(1);
        orderItem.setCart(customer.getCart());
        orderItem.setMenuItem(menuItem);
        orderItemDao.save(orderItem);
    }
}
