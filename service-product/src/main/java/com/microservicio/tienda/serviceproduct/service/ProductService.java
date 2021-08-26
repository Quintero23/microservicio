package com.microservicio.tienda.serviceproduct.service;

import com.microservicio.tienda.serviceproduct.entity.Categoria;
import com.microservicio.tienda.serviceproduct.entity.Producto;

import java.util.List;

public interface ProductService {

    public List<Producto> listAllProduct();
    public Producto getProduct(Long id);

    public Producto createProduct(Producto producto);
    public Producto updateProduct(Producto producto);
    public  Producto deleteProduct(Long id);
    public List<Producto> findByCategory(Categoria categoria);
    public Producto updateStock(Long id, Double quantity);
}
