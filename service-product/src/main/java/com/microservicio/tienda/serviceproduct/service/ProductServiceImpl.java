package com.microservicio.tienda.serviceproduct.service;

import com.microservicio.tienda.serviceproduct.entity.Categoria;
import com.microservicio.tienda.serviceproduct.entity.Producto;
import com.microservicio.tienda.serviceproduct.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{


    private final ProductRepository productRepository;


    @Override
    public List<Producto> listAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Producto getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Producto createProduct(Producto producto) {
        producto.setEstado("Creado");
        producto.setFechaCreacion(new Date());
        return productRepository.save(producto);
    }

    @Override
    public Producto updateProduct(Producto producto) {
        Producto productDB = getProduct(producto.getId());
        if (null == productDB){
            return null;
        }
        productDB.setNombre(producto.getNombre());
        productDB.setDescripcion(producto.getDescripcion());
        productDB.setCategoria(producto.getCategoria());
        productDB.setPrice(producto.getPrice());
        return productRepository.save(productDB);
    }

    @Override
    public Producto deleteProduct(Long id) {
        Producto productDB = getProduct(id);
        if (null == productDB){
            return null;
        }
        productDB.setEstado("DELETED");
        return productRepository.save(productDB);
    }

    @Override
    public List<Producto> findByCategory(Categoria categoria) {
        return productRepository.findByCategoria(categoria);
    }

    @Override
    public Producto updateStock(Long id, Double quantity) {
        Producto productDB = getProduct(id);
        if (null == productDB){
            return null;
        }
        Double stock =  productDB.getStock() + quantity;
        productDB.setStock(stock);
        return productRepository.save(productDB);
    }
}
