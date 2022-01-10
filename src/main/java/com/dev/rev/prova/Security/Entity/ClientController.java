package com.dev.rev.prova.Security.Entity;

import com.dev.rev.prova.Security.Service.ImplementacaoUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/user")
@RestController
public class ClientController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    private ImplementacaoUserDetailsService usuarioService;

    @PostMapping("/register")
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
        System.out.println(usuario);
        usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
        usuarioService.insereAcessoPadrao(usuario.getId());
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);

    }
}
