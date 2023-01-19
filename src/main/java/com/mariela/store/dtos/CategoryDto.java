package com.mariela.store.dtos;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CategoryDto extends BaseDto {
    @NotBlank
    private String name;
}
