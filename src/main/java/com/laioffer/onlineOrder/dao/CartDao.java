package com.laioffer.onlineOrder.dao;

import com.laioffer.onlineOrder.entity.Cart;
import com.laioffer.onlineOrder.entity.OrderItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void removeCartItem(int orderItemId) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            OrderItem item = session.get(OrderItem.class, orderItemId);
            Cart cart = item.getCart();
            cart.getOrderItemList().remove(item);

            session.beginTransaction();
            session.delete(item);
            session.getTransaction().commit();

        } catch(Exception e) {
            if(session == null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void removeAllCartItems(Cart cart) {
        for(OrderItem item: cart.getOrderItemList()) {
            removeCartItem(item.getId());
        }
    }
}
