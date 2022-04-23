package model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name="Carts")
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToMany
    private List<CartEntry> cartEntries = new ArrayList<>();


    public void addCartEntry(CartEntry cartEntry) {
        cartEntries.add(cartEntry);
    }

    public void removeCartEntry(CartEntry cartEntry) {
        cartEntries.remove(cartEntry);
    }

    public void clear() {
        cartEntries.clear();
    }




    public Integer getTotalQuantity() {
        return cartEntries.stream().mapToInt(CartEntry::getQuantity).sum();
    }


}
