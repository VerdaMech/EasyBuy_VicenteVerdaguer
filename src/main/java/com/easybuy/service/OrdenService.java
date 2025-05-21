package com.easybuy.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.easybuy.model.Orden;
import com.easybuy.repository.OrdenRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    public List<Orden> findAll(){
        return ordenRepository.findAll();
    }

    public Orden findById(Long id){
        return ordenRepository.findById(id).get();
    }

    public Orden save(Orden orden){
        return ordenRepository.save(orden);
    }

    public void delete(Long id){
        ordenRepository.deleteById(id);
    }

    public Orden patchOrden(Long id, Orden parcialOrder){
        Optional<Orden> ordenOpcional = ordenRepository.findById(id);
        if (ordenOpcional.isPresent()) {
            
            Orden ordenActualizar = ordenOpcional.get();
            
            if (parcialOrder.getFecha() != null) {
                ordenActualizar.setFecha(parcialOrder.getFecha());
            }
            if (parcialOrder.getTotal() != null) {
                ordenActualizar.setTotal(parcialOrder.getTotal());
            }
            return ordenRepository.save(ordenActualizar);
        } else {
            return null;
        }
    }
}
