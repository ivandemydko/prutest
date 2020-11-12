package com.example.prutest.mappers;

import com.example.prutest.entities.ProductLine;
import org.apache.ibatis.annotations.Mapper;

import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ProductLinesMapper {

    List <ProductLine> getAllProductLines();

    void addProductLine(ProductLine productLine);

    void updateProductLine(ProductLine productLine);

    ProductLine getProductLineByDescription(ProductLine productLine);

    void deleteProductLine(ProductLine productLine);
}
