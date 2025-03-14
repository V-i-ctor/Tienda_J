package com.tienda.service.Impl;

import com.tienda.dao.CategoriaDao; 
import com.tienda.domain.Categoria; 
import com.tienda.service.CategoriaService; 
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired //Injecta dependencias a nivel de Spring, utiliza informacion a nivel de JpaRepository
    private CategoriaDao categoriaDao; //Interfaz con JpaRepository

    @Override
    @Transactional(readOnly=true)//A nivel de base de datos, la trasaccion es de tipo de lectura
    public List<Categoria> getCategorias(boolean activos) {
        var lista=categoriaDao.findAll(); //Metodo findAll viene de la libreria JpaRepository
        if (activos) {
           lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
    
}
