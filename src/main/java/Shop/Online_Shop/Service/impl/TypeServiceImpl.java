package Shop.Online_Shop.Service.impl;

import Shop.Online_Shop.Service.TypeService;
import Shop.Online_Shop.modеl.Type;
import Shop.Online_Shop.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeRepository typeRepository;


    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }

    @Override
    public Type getType(Long id) {
        return typeRepository.findById(id).orElseThrow();
    }

    @Override
    public Type addType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type updateType(Long id,Type type) {
        if (typeRepository.existsById(id)){
            type.setId(id);
            return typeRepository.save(type);
        }else {
            throw new RuntimeException("Такого типа продукта не существует по такому id: "+id);
        }
    }

    @Override
    public void deleteType(Long id) {
        typeRepository.deleteById(id);
    }


}
