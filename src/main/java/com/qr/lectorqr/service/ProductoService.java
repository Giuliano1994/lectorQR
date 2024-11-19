package com.qr.lectorqr.service;

import com.google.zxing.WriterException;
import com.qr.lectorqr.dto.ProductoDTO;
import com.qr.lectorqr.dto.ProductoRespuestaDTO;
import com.qr.lectorqr.entity.ProductoEntity;
import com.qr.lectorqr.exception.ProductoNotFoundException;
import com.qr.lectorqr.mapper.ProductoMapper;
import com.qr.lectorqr.repository.ProductoRepository;
import com.qr.lectorqr.utils.GeneradorQR;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class ProductoService {

    private final ProductoRepository repository;
    private final GeneradorQR generadorQR;

    @Autowired
    public ProductoService(ProductoRepository repository, GeneradorQR generadorQR) {
        this.repository = repository;
        this.generadorQR = generadorQR;
    }

    public List<ProductoEntity> getAll(){
        return repository.findAll();
    }

    public ProductoEntity getById(Long id) {
        ProductoEntity productoEntity = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado con el id: " + id));
        ProductoRespuestaDTO producto = ProductoMapper.toRespuestaDTO(productoEntity);
        System.out.println(producto.getCodigoQR());
        return productoEntity;
    }

    public ProductoEntity getProducto(String descripcion) {
       return null;
    }

    @Transactional
    public ProductoEntity save(ProductoDTO productoDTO) {
        ProductoEntity productoEntity = ProductoMapper.toEntity(productoDTO);
        ProductoEntity savedProduct = repository.save(productoEntity);
        try {
            String codigoQR = generadorQR.generarQRBase64(savedProduct.getId().toString());
            savedProduct.setCodigoQr(codigoQR);
            return repository.save(savedProduct);
        } catch (IOException | WriterException e) {
            // Manejo de excepciones
            throw new RuntimeException("Error al generar el código QR", e);
        }
    }


    public ProductoEntity deleteById(Long id) {
        if (!exist(id)) {
            throw new ProductoNotFoundException("Producto no encontrado con id: " + id);
        }
        ProductoEntity productoEliminado = getById(id);
        repository.deleteById(id);
        return productoEliminado;
    }

    public ProductoEntity editar(Long id, ProductoDTO productoDTO) {
        if (!exist(id)) {
            throw new ProductoNotFoundException("Producto no encontrado con id: " + id);
        }
        ProductoEntity producto = repository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException("Producto no encontrado con id: " + id));

       
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecioUnitario(productoDTO.getPrecioUnitario());
        producto.setPrecioMayorista(productoDTO.getPrecioMayorista());

        return repository.save(producto);

    }

    private boolean exist(Long id){
       return repository.existsById(id);
    }



}
