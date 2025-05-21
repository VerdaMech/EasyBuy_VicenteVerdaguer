package com.easybuy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easybuy.model.Categoria;
import com.easybuy.repository.CategoriaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }

    public Categoria findById(Long id){
        return categoriaRepository.findById(id).get();
    }

    public Categoria save(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public void delete(Long id){
        categoriaRepository.deleteById(id);
    }

    public Categoria patchCategoria(Long id, Categoria parcialCategoria){
        Optional<Categoria> categoriaOpcional = categoriaRepository.findById(id);
        if (categoriaOpcional.isPresent()) {
            
            Categoria categoriaActualizar = categoriaOpcional.get();
            
            if (parcialCategoria.getDescripcion() != null) {
                categoriaActualizar.setDescripcion(parcialCategoria.getDescripcion());
            }
            return categoriaRepository.save(categoriaActualizar);
        } else {
            return null;
        }
    }
}
