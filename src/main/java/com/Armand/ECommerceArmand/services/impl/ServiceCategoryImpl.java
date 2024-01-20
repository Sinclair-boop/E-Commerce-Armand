package com.Armand.ECommerceArmand.services.impl;

import com.Armand.ECommerceArmand.dtos.controllerResponse.CategoryDto;
import com.Armand.ECommerceArmand.mappers.MapperCategory;
import com.Armand.ECommerceArmand.models.Category;
import com.Armand.ECommerceArmand.reposytories.RepositoryCategory;
import com.Armand.ECommerceArmand.services.ServiceCategory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServiceCategoryImpl implements ServiceCategory {
    private final RepositoryCategory repositoryCategory;
    private final MapperCategory mapperCategory;

    @Override
    public void serviceCreateCategory(CategoryDto categoryDto) {
        try{
            var categoryToSave = mapperCategory.convertCategoryDtoToCategory(categoryDto);
            if (categoryDto!=null) {
                repositoryCategory.save(categoryToSave); }else{ System.err.println("l'objet category est null");}
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Category serviceFindCategory(String id) {
        try{
            var currentCategory = repositoryCategory.findById(id).orElse(null);
            return currentCategory;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Category editeCategory(String id) {
        try{
            return null;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public List<Category> serviceGetAllCategories() {
        try{
            var currentCategory = repositoryCategory.findAll();
            return currentCategory;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Category serviceUpdateCategory(String id, CategoryDto category) {
        try {
            Optional<Category> existingCategory = repositoryCategory.findById(id);
            if (existingCategory.isPresent()) {
                Category categoryToUpdate = existingCategory.get();
                categoryToUpdate.setCode(category.getCode());
                categoryToUpdate.setName(category.getName());
                categoryToUpdate.setCreatedDAte(category.getCreatedDAte());
                categoryToUpdate.setModifiedDate(category.getModifiedDate());
                categoryToUpdate.setModifiedBy(category.getModifiedBy());
                return repositoryCategory.save(categoryToUpdate);
            } else {
                log.info("entite avec l'id {} n'existe pas", id);
                return null;
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void serviceDeleteCategory(String id) {
        try{
            repositoryCategory.deleteById(id);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
