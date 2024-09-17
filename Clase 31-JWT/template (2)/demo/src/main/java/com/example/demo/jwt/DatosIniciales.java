package com.example.demo.jwt;

import com.example.demo.Repository.UsuarioRepository;
import com.example.demo.model.Usuario;
import com.example.demo.model.UsuarioRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DatosIniciales implements ApplicationRunner {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
        String cifrado= passwordEncoder.encode("admin");
        usuarioRepository.save(new Usuario("Jorgito","admin","admin@admin.com",cifrado, UsuarioRole.ROLE_ADMIN));
    }
}
