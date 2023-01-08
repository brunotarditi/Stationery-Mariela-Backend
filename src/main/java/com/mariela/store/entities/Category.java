package com.mariela.store.entities;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Table(name = "category")
public class Category extends BaseEntity{

    @Column(name = "name", length = 65, nullable = false)
    @NotNull
    private String name;
}
