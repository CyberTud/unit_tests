package service;

import model.CartEntry;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CartEntryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartEntryService {

    private CartEntryRepository cartEntryRepository;


    public CartEntry createCartEntry(Integer quantity, Product product) {
        CartEntry cartEntry = new CartEntry();
        cartEntry.setQuantity(quantity);
        cartEntry.setProduct(product);
        return cartEntryRepository.save(cartEntry);
    }

    public Optional<CartEntry> findCartEntryById(Integer id) {
        return cartEntryRepository.findById(id);
    }

    public List<CartEntry> findAllCartEntries() {
        return cartEntryRepository.findAll();
    }

    public CartEntry updateCartEntry(CartEntry cartEntry) {
        return cartEntryRepository.save(cartEntry);
    }

    public void deleteCartEntryById(Integer id) {
        cartEntryRepository.deleteById(id);
    }

    public void deleteAllCartEntries() {
        cartEntryRepository.deleteAll();
    }
}
