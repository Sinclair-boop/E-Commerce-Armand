package com.Armand.ECommerceArmand.dtos.controllerResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private LocalDateTime createdDAte;
    private String modifiedBy;
    private LocalDateTime modifiedDate;
    private String code;
    private String name;

}
