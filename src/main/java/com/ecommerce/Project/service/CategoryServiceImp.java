package com.ecommerce.Project.service;

import com.ecommerce.Project.model.Category;
import com.ecommerce.Project.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class CategoryServiceImp implements CategoryService{
   // private List<Category> categories = new ArrayList<>();
 //   private Long id = 1L;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categoryRepository
                .findById(categoryId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found"));

        categoryRepository.delete(category);
//       List<Category> categories = categoryRepository.findAll();
//        Category category = categories.stream()
//                .filter(category1 -> category1.getCategoryId().equals(categoryId))
//                .findFirst()
//                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found.."));
//
//        categoryRepository.delete(category);
        return "Category with id : " + categoryId + " deleted successfully!!";
    }

    @Override
    public String updateCategory(Category category, Long categoryId) {
        Category category1 = categoryRepository
                .findById(categoryId)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));

        category.setCategoryId(categoryId);

        categoryRepository.save(category);

        return "Category with id " + categoryId + " was updated..";
//        List<Category> categories = categoryRepository.findAll();
//        Optional<Category> optionalCategory = categories.stream()
//                .filter(category1 -> category1.getCategoryId().equals(categoryId))
//                .findFirst();
//
//        if(optionalCategory.isPresent()){
//            Category category1 =optionalCategory.get();
//            category1.setCategoryName(category.getCategoryName());
//            Category savedCategory = categoryRepository.save(category1);
//            return "Category with id " + categoryId + " was updated..";
//        }
//        else
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with id"  + categoryId + " not found..");
    }
}
