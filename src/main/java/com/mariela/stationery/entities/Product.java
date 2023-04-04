package com.mariela.stationery.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "products")
public class Product extends BaseEntity {
    @Column(name = "name", length = 65, nullable = false)
    @NotNull
    private String name;
    @Transient
    private Double price;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_category")
    private Category category;

}
