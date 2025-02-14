package com.tienda.domain;

import jakarta.persistence.*; 
import java.io.Serializable; 
import lombok.Data;

@Data  /*Clase de tipo datos */
@Entity /*Referencia a una tabla en SQL*/
@Table(name="categoria")/*Especificamos la tabla a la que referencia*/
public class Categoria implements Serializable{ /*Serializable hace el trabajo de auto incrementar en este caso el ID de categoria que es AUTO INCREMENT en SQL*/

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id_categoria")
private Long idCategoria;

private String descripcion;
private String rutaImagen;
private boolean activo;

public Categoria() {
}
    
public Categoria(String categoria, boolean activo) {
        this.descripcion = categoria;
        this.activo = activo;
    }
}

