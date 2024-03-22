package Shop.Online_Shop.api;


import Shop.Online_Shop.Service.impl.ProductServiceImpl;
import Shop.Online_Shop.modеl.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productServiceImpl;
    @GetMapping
    public List<Product> getAllProducts(){
        return productServiceImpl.getAllProducts();
    }

    @GetMapping("{id}")
    public Product getProduct(@PathVariable(value = "id") Long id){
        return productServiceImpl.getProductById(id);
    }

    @GetMapping("{name}")
    public List<Product> searchProduct(@PathVariable(value = "name")String name){
        return productServiceImpl.searchProductByName(name);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productServiceImpl.addProduct(product);
    }

    @PutMapping
    public Product updateProduct(Long id,@RequestBody Product product){
        return productServiceImpl.updateProduct(id,product);
    }

    @DeleteMapping("{id}")
    public void deleteProduct(@PathVariable(value = "id")Long id){
        productServiceImpl.deleteProduct(id);
    }

}