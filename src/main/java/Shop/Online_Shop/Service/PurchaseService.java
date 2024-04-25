package Shop.Online_Shop.Service;

import Shop.Online_Shop.dto.PurchaseDto;
import java.util.List;

public interface PurchaseService {

    // Получить список всех покупок пользователя по его ID
    List<PurchaseDto> getPurchasesByUserId(Long userId);

}

