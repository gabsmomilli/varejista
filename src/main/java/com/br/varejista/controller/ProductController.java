package com.br.varejista.controller;

import com.br.varejista.model.Product;
import com.br.varejista.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/product")
@Tag(name = "Product Controller", description = "Product operations")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    @Operation(description = "Save new product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product created sucessfully", content = @Content(schema = @Schema(implementation = Product.class)))
    })
    public ResponseEntity saveNew(@RequestBody final Product newProduct) {
        Product savedProduct = service.save(newProduct, com.br.varejista.validator.Operation.INSERT);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @Operation(description = "Delete product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product deleted successfully", content = @Content(schema = @Schema(implementation = Product.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


    @Operation(description = "Find product by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully found", content = @Content(schema = @Schema(implementation = Product.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Integer id) {
        Product product = service.findById(id);
        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(description = "Update product by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product updated successfully", content = @Content(schema = @Schema(implementation = Product.class))),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Integer id, @RequestBody Product updatedProduct) {
        Product updated = service.updateProduct(id, updatedProduct);
        if (updated != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(description = "Find product by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully found", content = @Content(schema = @Schema(implementation = Product.class)))
    })
    @GetMapping("/find-by-description/{name}")
    public List<Product> findAllByProductName(@PathVariable("name") String name){
        return service.findAllByProductName(name);
    }

    @Operation(description = "Find Product by description")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully found", content = @Content(schema = @Schema(implementation = Product.class)))
    })
    @GetMapping("/find-by-description/{description}")
    public List<Product> findAllByProductDescription(@PathVariable("description") String description){
        return service.findAllByProductDescription(description);
    }

    @Operation(description = "Find product by price")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully found", content = @Content(schema = @Schema(implementation = Product.class)))
    })
    @GetMapping("/find-by-price/{price}")
    public List<Product> findAllByProductPrice(@PathVariable("price") Double price){
        return service.findAllByProductPrice(price);
    }

    @Operation(description = "Find product by size")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully found", content = @Content(schema = @Schema(implementation = Product.class)))
    })
    @GetMapping("/find-by-price/{size}")
    public List<Product> findAllByProductSize(@PathVariable("size") Integer size){
        return service.findAllByProductSize(size);
    }

    @Operation(description = "Find product by quantityInStock")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully found", content = @Content(schema = @Schema(implementation = Product.class)))
    })
    @GetMapping("/find-by-quantity-in-stock/{quantityInStock}")
    public List<Product> findAllByProductQuantityInStock(@PathVariable("quantityInStock") Integer quantityInStock){
        return service.findAllByProductQuantityInStock(quantityInStock);
    }

    @Operation(description = "Find product by color")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully found", content = @Content(schema = @Schema(implementation = Product.class)))
    })
    @GetMapping("/find-by-color/{color}")
    public List<Product> findAllByProductColor(@PathVariable("color") String color){
        return service.findAllByProductColor(color);
    }

    @Operation(description = "Find product by category")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully found", content = @Content(schema = @Schema(implementation = Product.class)))
    })
    @GetMapping("/find-by-category/{category}")
    public List<Product> findAllByProductCategory(@PathVariable("price") String category){
        return service.findAllByProductCategory(category);
    }

    @Operation(description = "Find product by brand")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully found", content = @Content(schema = @Schema(implementation = Product.class)))
    })
    @GetMapping("/find-by-brand/{brand}")
    public List<Product> findAllByProductBrand(@PathVariable("brand") String brand){
        return service.findAllByProductBrand(brand);
    }

    @Operation(description = "Find Product by dateRegister")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully found", content = @Content(schema = @Schema(implementation = Product.class)))
    })
    @GetMapping("/find-by-data-register/{dateRegister}")
    public List<Product> findAllByProductDateRegister(@PathVariable("dateRegister") LocalDate dateRegister){
        return service.findAllByProductDateRegister(dateRegister);
    }


    @Operation(description = "Find Product by dateRegister")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully found", content = @Content(schema = @Schema(implementation = Product.class)))
    })
    @GetMapping("/findAll")
    public List<Product> findAllByProductWithCombinedFilter(@RequestParam (required = false) String name,
                                                            @RequestParam (required = false) String description,
                                                            @RequestParam (required = false) Double price,
                                                            @RequestParam (required = false) Integer size,
                                                            @RequestParam (required = false) Integer quantityInStock,
                                                            @RequestParam (required = false) String color,
                                                            @RequestParam (required = false) String category,
                                                            @RequestParam (required = false) String brand,
                                                            @RequestParam (required = false) LocalDate dateRegister){

        return service.findAllByCombinedFilter(name, description, price, size, quantityInStock, color, category, brand, dateRegister);
    }
}