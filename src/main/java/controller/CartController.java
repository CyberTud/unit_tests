package controller;


import model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.CartService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/carts")
public class CartController {

    private CartService cartService;


    @PostMapping("/create")
    public Cart createCart() {
        return cartService.createCart(new Cart());
    }

    @GetMapping("/{id}")
    public Optional<Cart> getCartById(@PathVariable Integer id) {
        return cartService.findCartById(id);
    }

    @GetMapping("/sort-by-quantity")
    public List<Cart> getCartsSortedByQuantity() {
        return cartService.getCartsSortedByQuantity();
    }

    @GetMapping("/")
    public List<Cart> getAllCarts() {
        return cartService.findAllCarts();
    }

    @PostMapping("/update")
    public Cart updateCart(@RequestBody Cart cart) {
        return cartService.updateCart(cart);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCartById(@PathVariable Integer id) {
        cartService.deleteCartById(id);
    }

    @DeleteMapping("/delete")
    public void deleteAllCarts() {
        cartService.deleteAllCarts();
    }
}
