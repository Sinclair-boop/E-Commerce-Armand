package com.Armand.ECommerceArmand.mappers;

import com.Armand.ECommerceArmand.dtos.controllerResponse.CategoryDto;
import com.Armand.ECommerceArmand.models.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MapperCategory {
    public Category convertCategoryDtoToCategory(CategoryDto categoryDto){
        return Category.builder()
                .code(categoryDto.getCode())
                .createdDAte(categoryDto.getCreatedDAte())
                .name(categoryDto.getName())
                .modifiedBy(categoryDto.getModifiedBy())
                .modifiedDate(categoryDto.getModifiedDate())
                .build();
    }
}
