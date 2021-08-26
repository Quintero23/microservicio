package com.microservicio.tienda.serviceproduct.controller;

import com.microservicio.tienda.serviceproduct.entity.Categoria;
import com.microservicio.tienda.serviceproduct.entity.Producto;
import com.microservicio.tienda.serviceproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/productos")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Producto>> listProduct(@RequestParam(name="categoriaId", required = false) Long categoriaId) {
        List<Producto> productos = new ArrayList<>();
        if (categoriaId == null) {
            productos = productos = productService.listAllProduct();
            if (productos.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
        } else {
            productos = productService.findByCategory(Categoria.builder().id(categoriaId).build());
            if (productos.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
        }
        return ResponseEntity.ok(productos);
    }

    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto){
        Producto productoCreado = productService.createProduct(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productoCreado);
    }

    @RequestMapping(value = "/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable("id") Long id,@RequestBody Producto producto){
        producto.setId(id);
        Producto productoDB = productService.updateProduct(producto);
        if(productoDB == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productoDB);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Producto> eliminarProducto(@PathVariable("id") Long id){
        Producto productoDelete = productService.deleteProduct(id);
        if(productoDelete == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productoDelete);
    }

    @GetMapping(value = "/{id}/stock")
    public ResponseEntity<Producto> actualizarStock(@PathVariable long id, @RequestParam(name = "quantity", required = true) Double quantity){
        Producto productoStock = productService.updateStock(id, quantity);
        if(productoStock == null){
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(productoStock);
    }


}
