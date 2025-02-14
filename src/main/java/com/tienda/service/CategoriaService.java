package com.tienda.service;

import com.tienda.domain.Categoria; 
import java.util.List;

public interface CategoriaService {

    //Se obtiene listado de la BD
    public List<Categoria> getCategoria (boolean activos);
}
