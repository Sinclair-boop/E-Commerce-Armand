package com.Armand.ECommerceArmand.reposytories;

import com.Armand.ECommerceArmand.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RepositoryCategory extends MongoRepository<Category, String> {
}
