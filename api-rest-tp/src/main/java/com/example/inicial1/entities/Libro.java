package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Table(name = "Libro")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Date fecha;
    private String genero;
    private int paginas;
    private String autor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_persona")
    private Persona persona;

    @Builder.Default
    @ManyToMany(mappedBy = "libro")
    private Set<Autor> autores = new HashSet<>();

}
