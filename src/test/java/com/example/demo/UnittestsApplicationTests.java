package com.example.demo;

import controller.CartController;
import controller.CartEntryController;
import controller.ProductController;
import model.Cart;
import model.CartEntry;
import model.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@SpringBootTest
class UnittestsApplicationTests {

	private CartEntryController cartEntryController;
	private CartController cartController;

	private ProductController productController;

	private Product product;
	private CartEntry cartEntry;

	@BeforeAll
	void populateDatabase() throws Exception {

		product = new Product();
		product.setName("ciocolata");
		product.setPrice(9999.9999);
		cartEntry = new CartEntry();
		cartEntry.setQuantity(123);
		cartEntry.setProduct(product);
		product = productController.createProduct(product);
		cartEntry = cartEntryController.createCartEntry(2, product.getId());
	}



	@Test
	@Order(1)
	void givenProduct_ThenSaveCorrect() {
		Optional<Product> productFound = productController.getProductById(product.getId());
		assert productFound.isPresent();
		assert productFound.get().getName().equals(product.getName());
		assert Objects.equals(productFound.get().getPrice(), product.getPrice());
		assert Objects.equals(productFound.get().getId(), product.getId());
	}

	@Test
	@Order(2)
	void givenCartEntry_ThenSaveCorrect() {
		Optional<CartEntry> cartEntryFound = cartEntryController.getCartEntryById(cartEntry.getId());
		assert cartEntryFound.isPresent();
		assert Objects.equals(cartEntryFound.get().getQuantity(), cartEntry.getQuantity());
		assert Objects.equals(cartEntryFound.get().getProduct(), cartEntry.getProduct());
		assert Objects.equals(cartEntryFound.get().getId(), cartEntry.getId());
	}


	@Test
	@Order(3)
	void givenTwoCarts_WhenSortedByQuantity_ThenOrderCorrect() {
		List<Cart> carts = cartController.getCartsSortedByQuantity();
		assert carts.size() == 2;
		assert carts.get(0).getTotalQuantity() >= carts.get(1).getTotalQuantity();
	}

}
