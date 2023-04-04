package com.mariela.stationery.dtos;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class BaseDto {
    protected Long id;
    protected Date createAt;
    protected Date updateAt;
    protected boolean isEnabled;
}
