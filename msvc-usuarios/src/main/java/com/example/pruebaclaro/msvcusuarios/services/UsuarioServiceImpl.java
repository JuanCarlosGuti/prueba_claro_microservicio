package com.example.pruebaclaro.msvcusuarios.services;

import com.example.pruebaclaro.msvcusuarios.entity.Usuario;
import com.example.pruebaclaro.msvcusuarios.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    // Método para listar todos los usuarios
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listar() {
        return (List<Usuario>) repository.findAll();
    }

    // Método para obtener un usuario por su ID
    @Override
    @Transactional(readOnly = true)
    public Optional<Usuario> porId(Long id) {
        return repository.findById(id);
    }

    // Método para guardar un nuevo usuario o actualizar uno existente
    @Override
    @Transactional
    public Usuario guardar(Usuario usuario) {
        return repository.save(usuario);
    }

    // Método para eliminar un usuario por su ID
    @Override
    @Transactional
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    // Método para obtener un usuario por su dirección de correo electrónico
    @Override
    public Optional<Usuario> porEmail(String email) {
        return repository.porEmail(email);
    }
}
