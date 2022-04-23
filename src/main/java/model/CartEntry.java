package model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Objects;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CartEntry {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer quantity;

    @ManyToOne
    private Product product;



}
