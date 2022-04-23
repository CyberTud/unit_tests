package service;


import model.Cart;
import model.CartEntry;
import org.springframework.stereotype.Service;
import repository.CartRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    private CartRepository cartRepository;


    public Cart createCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public Optional<Cart> findCartById(Integer id) {
        return cartRepository.findById(id);
    }

    public List<Cart> findAllCarts() {
        return cartRepository.findAll();
    }

    public Cart updateCart(Cart cart) {
        return cartRepository.save(cart);
    }

    public void deleteCartById(Integer id) {
        cartRepository.deleteById(id);
    }

    public void deleteAllCarts() {
        cartRepository.deleteAll();
    }


    public Cart addCartEntry(Integer id, CartEntry cartEntry) {
        Optional<Cart> cart = findCartById(id);
        if (cart.isPresent()) {
            cart.get().addCartEntry(cartEntry);
            return updateCart(cart.get());
        } else {
            throw new IllegalArgumentException("Cart with id " + id + " not found");
        }
    }


    public Cart removeCartEntry(Integer id, CartEntry cartEntry) {
        Optional<Cart> cart = findCartById(id);
        if (cart.isPresent()) {
            cart.get().removeCartEntry(cartEntry);
            return updateCart(cart.get());
        } else {
            throw new IllegalArgumentException("Cart with id " + id + " not found");
        }
    }


    public Cart clearCart(Integer id) {
        Optional<Cart> cart = findCartById(id);
        if (cart.isPresent()) {
            cart.get().clear();
            return updateCart(cart.get());
        } else {
            throw new IllegalArgumentException("Cart with id " + id + " not found");
        }
    }


    public List<Cart> getCartsSortedByQuantity() {
        List<Cart> carts = findAllCarts();
        carts.sort(Comparator.comparingInt(Cart::getTotalQuantity).reversed());
        return carts;
    }
}
