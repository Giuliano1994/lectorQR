package com.qr.lectorqr.mapper;

import com.qr.lectorqr.dto.ProductoDTO;
import com.qr.lectorqr.dto.ProductoRespuestaDTO;
import com.qr.lectorqr.entity.ProductoEntity;

public class ProductoMapper {

    public static ProductoEntity toEntity(ProductoDTO dto) {
        if (dto == null) {
            return null;
        }

        ProductoEntity entity = new ProductoEntity();
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setPrecioUnitario(dto.getPrecioUnitario());
        entity.setPrecioMayorista(dto.getPrecioMayorista());
        return entity;
    }

    public static ProductoDTO toDTO(ProductoEntity entity) {
        if (entity == null) {
            return null;
        }

        ProductoDTO dto = new ProductoDTO();
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        dto.setPrecioUnitario(entity.getPrecioUnitario());
        dto.setPrecioMayorista(entity.getPrecioMayorista());
        return dto;
    }


    public static ProductoRespuestaDTO toRespuestaDTO(ProductoEntity entity) {
        if (entity == null) {
            return null;
        }

        ProductoRespuestaDTO dto = new ProductoRespuestaDTO();
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        dto.setPrecioUnitario(entity.getPrecioUnitario());
        dto.setPrecioMayorista(entity.getPrecioMayorista());
        dto.setCodigoQR(entity.getCodigoQr());
        return dto;
    }

}