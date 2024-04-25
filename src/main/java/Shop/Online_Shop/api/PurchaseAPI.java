package Shop.Online_Shop.api;


import Shop.Online_Shop.Service.PurchaseService;
import Shop.Online_Shop.dto.PurchaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseAPI {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("{userId}")
    public List<PurchaseDto> getPurchasesByUserId(@PathVariable(value = "userId") Long userId){
        return purchaseService.getPurchasesByUserId(userId);
    }
}
