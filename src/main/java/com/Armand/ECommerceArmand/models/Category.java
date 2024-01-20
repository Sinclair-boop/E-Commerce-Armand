package com.Armand.ECommerceArmand.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Category {
    @Id
    private String id;
    private LocalDateTime createdDAte;
    private String modifiedBy;
    private LocalDateTime modifiedDate;
    private String code;
    private String name;
}
