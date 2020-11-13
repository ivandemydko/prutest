package com.example.prutest.services;

import com.example.prutest.entities.ProductLine;
import com.example.prutest.mappers.ProductLinesMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
//@Log4j
public class ProductService {

//    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(LogExample.class);

    private ProductLinesMapper productLinesMapper;
    private ValidationService validationService;

    public List<ProductLine> getAllProductLines() {

//        System.out.println(log.isInfoEnabled());
        log.info("getAllProductLines method in ProductService was involved");
        return productLinesMapper.getAllProductLines();
    }

    public ProductLine getProductLineByDescription(String description) {
        ProductLine productLine = new ProductLine();
        productLine.setDescription(description);
        log.info("getProductLineByDescription method in ProductService was involved");
        return productLinesMapper.getProductLineByDescription(productLine);
    }

    public void addProductLine(String description) {
        validationService.isProductLineDescriptionLengthCorrect(description);
        ProductLine newProductLine = new ProductLine();
        newProductLine.setDescription(description);
        productLinesMapper.addProductLine(newProductLine);
    }

    public void updateProductLine(String oldDescription, String newDescription) {
        ProductLine productLine = getProductLineByDescription(oldDescription);
        productLine.setDescription(newDescription);
        productLinesMapper.updateProductLine(productLine);
    }

    public void deleteProductLine(String description) {
       ProductLine productLine = getProductLineByDescription(description);
       productLinesMapper.deleteProductLine(productLine);
    }

    public void addProductLine(ProductLine productLine) {
        productLinesMapper.addProductLine(productLine);
    }

}
