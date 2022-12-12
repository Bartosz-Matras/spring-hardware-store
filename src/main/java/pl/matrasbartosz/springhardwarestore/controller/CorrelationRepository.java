package pl.matrasbartosz.springhardwarestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.matrasbartosz.springhardwarestore.entity.ProductAlsoWatched;
import pl.matrasbartosz.springhardwarestore.service.CorrelationService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class CorrelationRepository {

    @Autowired
    private CorrelationService correlationService;

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/discounts/update")
    public void updateProductAlsoWatched(@RequestParam("ids") List<Long> ids, @RequestParam("id") Long id) {
        System.out.println(ids + " = " + id);
        for(Long tempId : ids){
            if(!Objects.equals(tempId, id)){
                ProductAlsoWatched productAlsoWatched =
                        correlationService.findProductAlsoWatchedByIdFatherProductAndIdProduct(tempId, id);
                productAlsoWatched.setWatchedCount(productAlsoWatched.getWatchedCount() + 1);
                correlationService.save(productAlsoWatched);
            }
        }
    }

}
