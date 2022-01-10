package com.dev.rev.prova.Security.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(value = "SELECT u FROM Usuario u WHERE u.login = ?1")
    Usuario findUserByLogin(String login);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE usuario SET user_token = ?1 WHERE user_login= ?2")
    void atualizaTokenUser(String token, String login);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "insert into usuarios_role (usuario_id, role_id) values(?1, (select id from roles where nome_role = 'ROLE_USER')); ")
    void insereAcessoRolePadrao(Long idUser);

}
