package com.example.pruebaclaro.msvcusuarios.repositories;


import com.example.pruebaclaro.msvcusuarios.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Consulta personalizada para obtener un usuario por su dirección de correo electrónico
    @Query("select u from Usuario u where u.email=?1")
    Optional<Usuario> porEmail(String email);


}
