package pl.matrasbartosz.springhardwarestore.dto;

import lombok.Data;
import pl.matrasbartosz.springhardwarestore.entity.Address;
import pl.matrasbartosz.springhardwarestore.entity.Customer;
import pl.matrasbartosz.springhardwarestore.entity.Order;
import pl.matrasbartosz.springhardwarestore.entity.OrderItem;

import java.util.Set;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
