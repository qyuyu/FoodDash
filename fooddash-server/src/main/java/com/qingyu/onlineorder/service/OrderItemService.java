package com.qingyu.onlineorder.service;

import com.qingyu.onlineorder.dao.OrderItemDao;
import com.qingyu.onlineorder.entity.Customer;
import com.qingyu.onlineorder.entity.MenuItem;
import com.qingyu.onlineorder.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemDao orderItemDao;

    @Autowired
    private MenuInfoService menuInfoService;

    @Autowired
    private CustomerService customerService;

    public void saveOrderItem(int menuItemId) {
        final OrderItem orderItem = new OrderItem();
        final MenuItem menuItem = menuInfoService.getMenuItem(menuItemId);

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String email = loggedInUser.getName();
        Customer customer = customerService.getCustomer(email);

        if (customer != null) {
            orderItem.setMenuItem(menuItem);
            orderItem.setCart(customer.getCart());
            orderItem.setPrice(menuItem.getPrice());
            orderItem.setQuantity(1);
        }
        orderItemDao.save(orderItem);
    }
}
