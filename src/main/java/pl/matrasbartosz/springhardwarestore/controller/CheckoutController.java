package pl.matrasbartosz.springhardwarestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.matrasbartosz.springhardwarestore.dto.Purchase;
import pl.matrasbartosz.springhardwarestore.dto.PurchaseResponse;
import pl.matrasbartosz.springhardwarestore.entity.Order;
import pl.matrasbartosz.springhardwarestore.entity.OrderItem;
import pl.matrasbartosz.springhardwarestore.entity.Product;
import pl.matrasbartosz.springhardwarestore.entity.ProductAlsoBought;
import pl.matrasbartosz.springhardwarestore.service.CheckoutService;
import pl.matrasbartosz.springhardwarestore.service.CorrelationService;
import pl.matrasbartosz.springhardwarestore.service.ProductService;

import java.util.Objects;
import java.util.Set;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;
    private final CorrelationService correlationService;
    private final ProductService productService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService, CorrelationService correlationService,
                              ProductService productService) {
        this.checkoutService = checkoutService;
        this.correlationService = correlationService;
        this.productService = productService;
    }

    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){
        Set<OrderItem> orderItems = purchase.getOrderItems();
        for (OrderItem item1 : orderItems){
            for (OrderItem item2 : orderItems) {
                if (!Objects.equals(item1.getProductId(), item2.getProductId())){
                    ProductAlsoBought productAlsoBought =
                            correlationService.findProductAlsoBoughtByIdFatherProductAndIdProduct(item1.getProductId(), item2.getProductId());
                    productAlsoBought.setBoughtCount(productAlsoBought.getBoughtCount() + 1);
                    correlationService.save(productAlsoBought);
                }
            }
        }

        for (OrderItem orderItem : orderItems) {
            Product product = productService.findProductById(orderItem.getProductId());
            product.setUnitsInStock(product.getUnitsInStock() - orderItem.getQuantity());
            if (product.getUnitsInStock() == 0) {
                product.setActive(false);
            }
            productService.save(product);
        }

        return checkoutService.placeOrder(purchase);
    }

}
