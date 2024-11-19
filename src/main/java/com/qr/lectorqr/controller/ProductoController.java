package com.qr.lectorqr.controller;

import com.qr.lectorqr.dto.ProductoDTO;
import com.qr.lectorqr.entity.ProductoEntity;
import com.qr.lectorqr.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService service;

    @Autowired
    public ProductoController(ProductoService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        List<ProductoEntity> productos = service.getAll();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        ProductoEntity producto = service.getById(id);
        return ResponseEntity.ok(producto);
    }

    @PostMapping("")
    public ResponseEntity<?> guardar(@RequestBody ProductoDTO productoDTO) {
        try {
            ProductoEntity producto = service.save(productoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(producto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al guardar el producto");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (service.deleteById(id) != null) {
            return ResponseEntity.ok("Producto eliminado correctamente"); // Devuelve 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado"); // Devuelve 404 NOT FOUND
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody ProductoDTO productoDTO) {
        ProductoEntity producto = service.editar(id, productoDTO);
        return ResponseEntity.ok(producto);
    }

}
