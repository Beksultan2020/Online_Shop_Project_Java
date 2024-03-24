package Shop.Online_Shop.Service.impl;

import Shop.Online_Shop.Service.TypeService;
import Shop.Online_Shop.modеl.Type;
import Shop.Online_Shop.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Type getType(Long id) {
        return typeRepository.findById(id).orElseThrow();
    }
}
