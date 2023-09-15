package service;

@Service
public class ServiceProduct 
{
    @Autowired
    private ProductRepository productRepository;
    
    
    public Product createProduct(Product product) 
    {
        return productRepository.save(product);
    }
    
    
    public List<Product> getAllProducts() 
    {
        return productRepository.findAll();
    }
    
    public Product getProductById(Long id) 
    {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
    }
    
    
    public Product updateProduct(Long id, Product updatedProduct)
    {
        Product existingProduct = getProductById(id);
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setDescription(updatedProduct.getDescription());
        return productRepository.save(existingProduct);
    }
    
    
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}
