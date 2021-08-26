package com.microservicio.tienda.serviceproduct;


import com.microservicio.tienda.serviceproduct.entity.Categoria;
import com.microservicio.tienda.serviceproduct.entity.Producto;
import com.microservicio.tienda.serviceproduct.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;
import java.util.List;

@DataJpaTest
public class ProductRepositoryMockTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void whereFindByCategoria_thenReturnListProduct() {
        Producto producto01 = Producto.builder()
                .nombre("Computer")
                .categoria(Categoria.builder().id(1L).build())
                .descripcion("")
                .stock(Double.parseDouble("10"))
                .price(Double.parseDouble("1240.40"))
                .estado("creado")
                .fechaCreacion(new Date()).build();
        productRepository.save(producto01);

        List<Producto> founds = productRepository.findByCategoria(producto01.getCategoria());

        Assertions.assertThat(founds.size()).isEqualTo(2);

    }

}
