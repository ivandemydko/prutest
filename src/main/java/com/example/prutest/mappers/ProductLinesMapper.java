package com.example.prutest.mappers;

import com.example.prutest.entities.ProductLine;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ProductLinesMapper {

//    @Select("SELECT * FROM CITY WHERE state = #{state}")
//    ProductLine findByState(@Param("state") String state);

//    @Select("SELECT * FROM ProductLines")
//   List <ProductLine> selectAllProductLines();
//
//    @Select("SELECT * FROM ProductLines WHERE id=1")
//    ProductLine selectProductLine();


    List <ProductLine> getAllProductLines();

    void addProductLine(ProductLine productLine);

    void updateProductLine(ProductLine productLine);

    ProductLine getProductLineByDescription(ProductLine productLine);

    void deleteProductLine(ProductLine productLine);
}
