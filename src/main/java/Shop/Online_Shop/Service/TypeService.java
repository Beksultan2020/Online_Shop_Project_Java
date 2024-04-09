package Shop.Online_Shop.Service;

import Shop.Online_Shop.model.Type;

import java.util.List;

public interface TypeService {

    List<Type> getAllTypes();
    Type getType(Long id);

    Type addType(Type type);

    Type updateType(Long id, Type type);

    void deleteType(Long id);
}
