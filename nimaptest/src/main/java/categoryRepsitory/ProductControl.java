package controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductControl
{
	@Autowired
	    private ProductRepository productRepository;

	    @GetMapping
	    public Page<Product> getAllProducts(Pageable pageable) {
	        return productRepository.findAll(pageable);
	    }

	    @PostMapping
	    public Product createProduct(@RequestBody Product product) {
	        return productRepository.save(product);
	    }

	    @GetMapping("/{id}")
	    public Product getProductById(@PathVariable Long id) {
	        return productRepository.findById(id).orElse(null);
	    }

	    @PutMapping("/{id}")
	    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
	        Product product = productRepository.findById(id).orElse(null);
	        if (product != null) {
	            product.setName(updatedProduct.getName());
	            product.setPrice(updatedProduct.getPrice());
	            // Update other properties if needed
	            return productRepository.save(product);
	        }
	        return null;
	    }

	    @DeleteMapping("/{id}")
	    public void deleteProduct(@PathVariable Long id) {
	        productRepository.deleteById(id);
	    }
	}


}
