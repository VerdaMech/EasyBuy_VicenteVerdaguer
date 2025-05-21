package com.easybuy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.easybuy.model.Producto;
import com.easybuy.repository.ProductoRepository;
import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> findAll(){
        return productoRepository.findAll();
    }

    public Producto findById(Long id){
        return productoRepository.findById(id).get();
    }

    public Producto save(Producto producto){
        return productoRepository.save(producto);
    }

    public void delete(Long id){
        productoRepository.deleteById(id);
    }

    public List<Producto> buscarProductoPorLetra(String letra){
        return productoRepository.buscarProductoPorLetraInicial(letra);
    }

    public Producto patchProducto(Long id, Producto parcialProducto){
        Optional<Producto> productoOpcional = productoRepository.findById(id);
        if (productoOpcional.isPresent()) {
            
            Producto productoActualizar = productoOpcional.get();
            
            if (parcialProducto.getNombre_producto() != null) {
                productoActualizar.setNombre_producto(parcialProducto.getNombre_producto());
            }

            if(parcialProducto.getPrecio() != 0) {
                productoActualizar.setPrecio(parcialProducto.getPrecio());
            }

            if(parcialProducto.getCantidad() != 0) {
                productoActualizar.setCantidad(parcialProducto.getCantidad());
            }
            return productoRepository.save(productoActualizar);
        } else {
            return null;
        }
    }
}
