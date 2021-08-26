package com.microservicio.tienda.serviceproduct.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="categoria")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class Categoria {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
}
