package com.pershyn.electronicshop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "product")
@EqualsAndHashCode(exclude = {"product_id", "category", "cartItems"})
@ToString(exclude = "cartItems")
@NoArgsConstructor
public class Product {

    @Id
    @Column(name = "product_id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;

    @Size(min = 1, max = 64)
    @Column(name = "title")
    private String title;

    @Column(name = "active", columnDefinition = "boolean default true")
    private Boolean active = true;

    @Size(min = 3)
    @Column(name = "description")
    private String description;

    @Column(name = "small_image_link")
    private String smallImageLink;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    @Digits(integer = 9, fraction = 2)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Item> cartItems = new HashSet<>();

}
