package cart.service;

import cart.entity.Product;
import cart.exception.ProductNotFoundException;
import cart.repository.ProductRepository;
import cart.service.dto.ProductHttpRequest;
import cart.service.dto.ProductHttpResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductHttpResponse> findAll() {
        return productRepository.findAll().stream()
                .map(ProductService::toResponse)
                .collect(Collectors.toUnmodifiableList());
    }

    public long createProduct(final ProductHttpRequest httpRequest) {
        final Product savedProduct = productRepository.save(toProduct(httpRequest));
        return savedProduct.getId();
    }

    public void updateProduct(final ProductHttpRequest productHttpRequest) {
        final int updatedCount = productRepository.update(toProduct(productHttpRequest));
        if (updatedCount == 0) {
            throw new ProductNotFoundException();
        }
    }

    public void deleteById(final long id) {
        productRepository.deleteById(id);
    }

    private static ProductHttpResponse toResponse(final Product product) {
        return new ProductHttpResponse(product.getId(), product.getName(), product.getImageUrl(),
                product.getPrice());
    }

    private static Product toProduct(final ProductHttpRequest productHttpRequest) {
        if (productHttpRequest.getId() == null) {
            return new Product(productHttpRequest.getName(), productHttpRequest.getImageUrl(),
                    productHttpRequest.getPrice());
        }
        return new Product(productHttpRequest.getId(), productHttpRequest.getName(), productHttpRequest.getImageUrl(),
                productHttpRequest.getPrice());
    }
}
