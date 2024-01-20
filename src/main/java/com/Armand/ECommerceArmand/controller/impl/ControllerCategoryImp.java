package com.Armand.ECommerceArmand.controller.impl;

import com.Armand.ECommerceArmand.controller.ControllerCategory;
import com.Armand.ECommerceArmand.dtos.controllerResponse.*;
import com.Armand.ECommerceArmand.services.ServiceCategory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@Slf4j
@RestController
public class ControllerCategoryImp implements ControllerCategory {
    private final ResponsesDetails responsesDetails;
    private final ServiceCategory serviceCategory;
    @Override
    public ResponseEntity<ResponseDto> controllerPerformCategory(@RequestBody CategoryDto dto){
        try {
            serviceCategory.serviceCreateCategory(dto);
            return new ResponseEntity<>(ResponseDto.builder()
                    .data(null)
                    .errors(null)
                    .meta(MetaDto.builder().message("Creation d'une category")
                            .statusCode(HttpStatus.OK.value()).statusDescription("Réussi").build())
                    .pagination(PaginationDto.builder().count(0).total(0).build())
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            // Construit une réponse d'erreur en cas d'exception.
            return new ResponseEntity<>(responsesDetails.GetErrorResponseDetails(e.getMessage(),
                    HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<ResponseDto> controllerGetAllCategory() {
        try {
            var getAllCategory = serviceCategory.serviceGetAllCategories();
            return new ResponseEntity<>(ResponseDto.builder()
                    .data(getAllCategory)
                    .errors(null)
                    .meta(MetaDto.builder().message("La liste des categories")
                            .statusCode(HttpStatus.OK.value()).statusDescription("Réussi").build())
                    .pagination(PaginationDto.builder().count(0).total(0).build())
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            // Construit une réponse d'erreur en cas d'exception.
            return new ResponseEntity<>(responsesDetails.GetErrorResponseDetails(e.getMessage(),
                    HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<ResponseDto> controllerGetCategory(String id) {
        try {
            var getCategory = serviceCategory.serviceFindCategory(id);
            return new ResponseEntity<>(ResponseDto.builder()
                    .data(getCategory)
                    .errors(null)
                    .meta(MetaDto.builder().message("selection de la category avec l'id: "+id)
                            .statusCode(HttpStatus.OK.value()).statusDescription("Réussi").build())
                    .pagination(PaginationDto.builder().count(0).total(0).build())
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            // Construit une réponse d'erreur en cas d'exception.
            return new ResponseEntity<>(responsesDetails.GetErrorResponseDetails(e.getMessage(),
                    HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<ResponseDto> controllerUpdateCategory(String id, CategoryDto categoryDto) {
        try {
           var responseUpdateCategory = serviceCategory.serviceUpdateCategory(id, categoryDto);
            return new ResponseEntity<>(ResponseDto.builder()
                    .data(responseUpdateCategory)
                    .errors(null)
                    .meta(MetaDto.builder().message("mise a jour d'une category avec id: "+id)
                            .statusCode(HttpStatus.OK.value()).statusDescription("Réussi").build())
                    .pagination(PaginationDto.builder().count(0).total(0).build())
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(responsesDetails.GetErrorResponseDetails(e.getMessage(),
                    HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<ResponseDto> controllerDeleteCategory(String id) {
        try {
            serviceCategory.serviceDeleteCategory(id);
            return new ResponseEntity<>(ResponseDto.builder()
                    .data(null)
                    .errors(null)
                    .meta(MetaDto.builder().message("supression de la category avec id: "+id)
                            .statusCode(HttpStatus.OK.value()).statusDescription("Réussi").build())
                    .pagination(PaginationDto.builder().count(0).total(0).build())
                    .build(), HttpStatus.OK);
        } catch (Exception e) {
            // Construit une réponse d'erreur en cas d'exception.
            return new ResponseEntity<>(responsesDetails.GetErrorResponseDetails(e.getMessage(),
                    HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
        }
    }

}
