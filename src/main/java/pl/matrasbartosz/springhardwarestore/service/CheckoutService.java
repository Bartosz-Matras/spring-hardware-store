package pl.matrasbartosz.springhardwarestore.service;

import pl.matrasbartosz.springhardwarestore.dto.Purchase;
import pl.matrasbartosz.springhardwarestore.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
