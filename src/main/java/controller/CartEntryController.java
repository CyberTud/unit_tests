package controller;


import model.CartEntry;
import model.Product;
import org.springframework.web.bind.annotation.*;
import service.CartEntryService;
import service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cartentry")
public class CartEntryController {

    private CartEntryService cartEntryService;
    private ProductService productService;

    @GetMapping("/{id}")
    public Optional<CartEntry> getCartEntryById(@PathVariable Integer id) {
        return cartEntryService.findCartEntryById(id);
    }

    @GetMapping("/")
    public List<CartEntry> getAllCartEntries() {
        return cartEntryService.findAllCartEntries();
    }

    @PostMapping("/create")
    public CartEntry createCartEntry(@RequestParam Integer quantity, @RequestParam Integer productId) throws Exception {
        Optional<Product> product = productService.findProductById(productId);
        if (product.isPresent()) {
            return cartEntryService.createCartEntry(quantity, product.get());
        } else {
            throw new Exception(productId + " doesn't exit");
        }
    }


    @PostMapping("/update")
    public CartEntry updateCartEntry(@RequestBody CartEntry cartEntry) {
        return cartEntryService.updateCartEntry(cartEntry);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCartEntry(@PathVariable Integer id) {
        cartEntryService.deleteCartEntryById(id);
    }

    @DeleteMapping("/delete")
    public void deleteAllCartEntries() {
        cartEntryService.deleteAllCartEntries();
    }
}
