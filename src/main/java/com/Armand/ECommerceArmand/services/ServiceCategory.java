package com.Armand.ECommerceArmand.services;

import com.Armand.ECommerceArmand.dtos.controllerResponse.CategoryDto;
import com.Armand.ECommerceArmand.models.Category;

import java.util.List;

public interface ServiceCategory {
    void serviceCreateCategory(CategoryDto categoryDto);
    Category serviceFindCategory(String id);
    Category editeCategory(String id);
    List<Category> serviceGetAllCategories();
    Category serviceUpdateCategory(String id, CategoryDto category);
    void serviceDeleteCategory(String id);

}
