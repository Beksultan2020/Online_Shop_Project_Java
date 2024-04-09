package Shop.Online_Shop.api;


import Shop.Online_Shop.Service.impl.TypeServiceImpl;
import Shop.Online_Shop.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeAPI {
    @Autowired
    private TypeServiceImpl typeServiceImpl;

    @GetMapping
    public List<Type> getAllTypes(){
        return typeServiceImpl.getAllTypes();
    }

    @GetMapping("{id}")
    public Type getType(@PathVariable(value = "id")Long id){
        return typeServiceImpl.getType(id);
    }

    @PostMapping
    public Type addType(@RequestBody Type type){
        return typeServiceImpl.addType(type);
    }

    @PutMapping("{id}")
    public Type updateType( @PathVariable(value = "id")Long id,@RequestBody Type type){
        return typeServiceImpl.updateType(id,type);
    }

    @DeleteMapping("{id}")
    public  void deleteType(@PathVariable(value = "id")Long id){
        typeServiceImpl.deleteType(id);
    }
}
