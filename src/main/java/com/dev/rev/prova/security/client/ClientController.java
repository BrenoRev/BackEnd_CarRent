package com.dev.rev.prova.security.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.rev.prova.security.service.ImplementacaoUserDetailsService;

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
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getPassword()));
		usuarioRepository.save(usuario);
		usuarioService.insereAcessoPadrao(usuario.getId());
		return new ResponseEntity<>(usuario, HttpStatus.OK);

	}
}
