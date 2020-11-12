package com.example.prutest.controllers;

import com.example.prutest.entities.ProductLine;
import com.example.prutest.exceptions.LengthValidationException;
import com.example.prutest.mappers.ProductLinesMapper;
import com.example.prutest.services.ProductService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("product")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("/productLine/all")
    public List<ProductLine> productLines() {
        return productService.getAllProductLines();
    }

    @PostMapping("productLine/add")
    public void addProductLine(@Valid @RequestParam(name = "description") String description) {
        productService.addProductLine(description);
    }

    @PutMapping("productLine/update")
    public void updateProductLine(@RequestParam(name = "oldDescription") String oldDescription,
                                  @RequestParam(name = "newDescription") String newDescription) {
        productService.updateProductLine(oldDescription, newDescription);
    }

    @DeleteMapping("productLine/delete")
    public void deleteProductLine(@RequestParam(name = "description") String description) {
        productService.deleteProductLine(description);
    }

    @PostMapping("productLine/addWithBody")
    @ApiOperation(value = "Adds product line",
                  notes = "requires object of 'ProductLine' for request body.")
    public void addProductLineWithBody(@Valid @RequestBody ProductLine productLine) {
        productService.addProductLine(productLine);
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public String handleException() {
        return "This product line already exists";
    }

//    @ExceptionHandler(LengthValidationException.class)
//    public String lengthHandleException() {
//        return "length error";
//    }

//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    public String responseHandleException() {
//        return "Bad request!!!";
//    }

//    @ExceptionHandler
//    @ResponseStatus(value = HttpStatus.NOT_FOUND)
//    public Map<String, String> notFoundHandler(NotFoundException e){
//        return Collections.singletonMap("messagehbbhbhbbhb", e.getMessage());
//    }

}
