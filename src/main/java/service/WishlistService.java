package service;

import model.Product;
import model.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.WishlistRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {

    private WishlistRepository wishlistRepository;

    public Wishlist createWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    public Optional<Wishlist> findWishlistById(Integer id) {
        return wishlistRepository.findById(id);
    }

    public List<Wishlist> findAllWishlists() {
        return wishlistRepository.findAll();
    }

    public Wishlist updateWishlist(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    public void deleteWishlistById(Integer id) {
        wishlistRepository.deleteById(id);
    }

    public void deleteAllWishlists() {
        wishlistRepository.deleteAll();
    }


    public Wishlist addToWishlist(Integer id, Product product) {
        Optional<Wishlist> wishlist = findWishlistById(id);
        if (wishlist.isPresent()) {
            wishlist.get().addProduct(product);
            return updateWishlist(wishlist.get());
        } else {
            throw new IllegalArgumentException("Wishlist with id " + id + " does not exist.");
        }
    }


    public Wishlist removeFromWishlist(Integer id, Product product) {
        Optional<Wishlist> wishlist = findWishlistById(id);
        if (wishlist.isPresent()) {
            wishlist.get().removeProduct(product);
            return updateWishlist(wishlist.get());
        } else {
            throw new IllegalArgumentException("Wishlist with id " + id + " does not exist.");
        }
    }


    public Wishlist clearWishlist(Integer id) {
        Optional<Wishlist> wishlist = findWishlistById(id);
        if (wishlist.isPresent()) {
            wishlist.get().clear();
            return updateWishlist(wishlist.get());
        } else {
            throw new IllegalArgumentException("Wishlist with id " + id + " does not exist.");
        }
    }
}
