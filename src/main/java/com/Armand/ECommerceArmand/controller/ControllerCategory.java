package com.Armand.ECommerceArmand.controller;

import com.Armand.ECommerceArmand.dtos.controllerResponse.CategoryDto;
import com.Armand.ECommerceArmand.dtos.controllerResponse.ResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("ECommerceV1/")
public interface ControllerCategory {
    @PostMapping("create/category")
    ResponseEntity<ResponseDto> controllerPerformCategory(@RequestBody CategoryDto dto);
    @GetMapping("getAll/categories")
    ResponseEntity<ResponseDto> controllerGetAllCategory();
    @GetMapping("get/category/{id}")
    ResponseEntity<ResponseDto> controllerGetCategory(@PathVariable String id);
    @PutMapping("update/category/{id}")
    ResponseEntity<ResponseDto> controllerUpdateCategory(@PathVariable String id, @RequestBody CategoryDto categoryDto);
    @DeleteMapping("delete/category/{id}")
    ResponseEntity<ResponseDto> controllerDeleteCategory(@PathVariable String id);
}
