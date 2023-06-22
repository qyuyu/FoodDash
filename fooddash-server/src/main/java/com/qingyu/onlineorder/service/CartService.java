package com.qingyu.onlineorder.service;

import com.qingyu.onlineorder.dao.CartDao;
import com.qingyu.onlineorder.entity.Cart;
import com.qingyu.onlineorder.entity.Customer;
import com.qingyu.onlineorder.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CartDao cartDao;

    public Cart getCart() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String email = loggedInUser.getName();
        Customer customer = customerService.getCustomer(email);

        if (customer != null) {
            Cart cart = customer.getCart();
            double totalPrice = 0;
            for (OrderItem item : cart.getOrderItemList()) {
                totalPrice += item.getPrice() * item.getQuantity();
            }

            cart.setTotalPrice(totalPrice);
            return cart;
        }

        return new Cart();
    }

    public void cleanCart() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String email = loggedInUser.getName();
        Customer customer = customerService.getCustomer(email);

        if (customer != null) {
            cartDao.removeAllCartItems(customer.getCart());
        }
    }
}
