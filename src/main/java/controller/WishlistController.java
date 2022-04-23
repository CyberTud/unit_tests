package controller;


import model.Wishlist;
import org.springframework.web.bind.annotation.*;
import service.WishlistService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/wishlists")
public class WishlistController {

    private WishlistService wishlistService;


    @PostMapping("/create")
    public Wishlist createWishlist(@RequestBody Wishlist wishlist) {
        return wishlistService.createWishlist(wishlist);
    }

    @GetMapping("/{id}")
    public Optional<Wishlist> getWishlistById(@PathVariable Integer id) {
        return wishlistService.findWishlistById(id);
    }

    @GetMapping("/")
    public List<Wishlist> getAllWishlists() {
        return wishlistService.findAllWishlists();
    }

    @PostMapping("/update")
    public Wishlist updateWishlist(@RequestBody Wishlist wishlist) {
        return wishlistService.updateWishlist(wishlist);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteWishlistById(@PathVariable Integer id) {
        wishlistService.deleteWishlistById(id);
    }

    @DeleteMapping("/delete")
    public void deleteAllWishlists() {
        wishlistService.deleteAllWishlists();
    }
}
