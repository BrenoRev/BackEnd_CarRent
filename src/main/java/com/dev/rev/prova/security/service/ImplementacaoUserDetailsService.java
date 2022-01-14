package com.dev.rev.prova.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dev.rev.prova.security.client.Usuario;
import com.dev.rev.prova.security.client.UsuarioRepository;

@Service
public class ImplementacaoUserDetailsService implements UserDetailsService{

    @Autowired
    UsuarioRepository usuarioRepository;
    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Consultar no banco o usuario

        Usuario usuario = usuarioRepository.findUserByLogin(username);

        if(usuario == null) {
            throw new UsernameNotFoundException("Usuario não foi encontrado");
        }

        return new User(usuario.getLogin(), usuario.getPassword(), usuario.getAuthorities());
    }


    public void atualizaToken(String token, String login) {
        usuarioRepository.atualizaTokenUser(token, login);
    }


    public void insereAcessoPadrao(Long id) {
		usuarioRepository.insereAcessoRolePadrao(id);
	}

}