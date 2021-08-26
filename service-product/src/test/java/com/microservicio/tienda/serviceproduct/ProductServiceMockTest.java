package com.microservicio.tienda.serviceproduct;

import com.microservicio.tienda.serviceproduct.entity.Categoria;
import com.microservicio.tienda.serviceproduct.entity.Producto;
import com.microservicio.tienda.serviceproduct.repository.ProductRepository;
import com.microservicio.tienda.serviceproduct.service.ProductService;
import com.microservicio.tienda.serviceproduct.service.ProductServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class ProductServiceMockTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
        productService =  new ProductServiceImpl( productRepository);
        Producto computer =  Producto.builder()
                .id(1L)
                .nombre("computer")
                .categoria(Categoria.builder().id(1L).build())
                .price(Double.parseDouble("12.5"))
                .stock(Double.parseDouble("5"))
                .build();

        Mockito.when(productRepository.findById(1L))
                .thenReturn(Optional.of(computer));

        Mockito.when(productRepository.save(computer)).thenReturn(computer);
    }
    @Test
    public void whenValidGetID_ThenReturnProduct(){
        Producto found = productService.getProduct(1L);
        Assertions.assertThat(found.getNombre()).isEqualTo("computer");
    }

    @Test
    public void WhenValidUpdateStock_ThenReturnNewStock(){
        Producto newStock = productService.updateStock(1L,Double.parseDouble("8"));
        Assertions.assertThat(newStock.getStock()).isEqualTo(13);
    }

}
