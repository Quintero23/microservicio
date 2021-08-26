package com.microservicio.tienda.serviceproduct.repository;


import com.microservicio.tienda.serviceproduct.entity.Categoria;
import com.microservicio.tienda.serviceproduct.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository  extends JpaRepository<Producto, Long> {

    public List<Producto> findByCategoria(Categoria categoria);
}
