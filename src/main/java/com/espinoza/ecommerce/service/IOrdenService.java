package com.espinoza.ecommerce.service;

import com.espinoza.ecommerce.model.Orden;
import com.espinoza.ecommerce.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface IOrdenService {

    List<Orden> findAll();
    Optional<Orden> findById(Integer id);
    Orden save (Orden orden);
    String generarNumeroOrden();
    List<Orden> findByUsuario (Usuario usuario);

}
