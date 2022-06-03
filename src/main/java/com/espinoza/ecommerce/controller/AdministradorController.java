package com.espinoza.ecommerce.controller;

import com.espinoza.ecommerce.model.Orden;
import com.espinoza.ecommerce.model.Producto;
import com.espinoza.ecommerce.service.IOrdenService;
import com.espinoza.ecommerce.service.IUsuarioService;
import com.espinoza.ecommerce.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/administrador")
public class AdministradorController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private IUsuarioService usuarioService;

    @Autowired
    private IOrdenService ordenService;

    private Logger logg= LoggerFactory.getLogger(AdministradorController.class);

    @GetMapping("")
    public String home(Model model){

        List<Producto> productos=productoService.findAll();
        model.addAttribute("productos",productos);

        return "admin/home";
    }

    @GetMapping("/usuarios")
    public String usuarios(Model model){
        model.addAttribute("usuarios",usuarioService.findAll());
        return "admin/usuarios";
    }

    @GetMapping("/ordenes")
    public String ordenes(Model model){
        model.addAttribute("ordenes",ordenService.findAll());
        return "admin/ordenes";
    }

    @GetMapping("/detalle/{id}")
    public String detalle(@PathVariable Integer id,Model model){
        logg.info("Este es el id: {}",id);
        Orden orden=ordenService.findById(id).get();

        model.addAttribute("detalles",orden.getDetalle());

        return "admin/detalleorden";
    }
}
