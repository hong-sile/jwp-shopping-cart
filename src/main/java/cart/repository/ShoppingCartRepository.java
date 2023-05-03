package cart.repository;

import cart.entity.Product;
import java.util.List;

public interface ShoppingCartRepository {

    void addProduct(long memberId, long productId);

    void removeProduct(long memberId, long productId);

    List<Product> findAllProduct(long memberId);
}
