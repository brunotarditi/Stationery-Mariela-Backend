package com.mariela.stationery.dtos;

import com.mariela.stationery.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ProductDto extends BaseDto {
    @NotBlank
    private String name;
    private Double price;
    private Category category;

}
