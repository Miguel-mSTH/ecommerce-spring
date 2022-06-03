package com.espinoza.ecommerce.service;

import com.espinoza.ecommerce.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    public Producto save(Producto producto);
    public Optional<Producto> get(Integer id); //para ver sis existe ese producto
    public void update(Producto producto);
    public void delete(Integer id);
    public List<Producto> findAll();
}
