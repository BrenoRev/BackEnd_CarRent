package com.dev.rev.prova.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import com.dev.rev.prova.Security.Service.ImplementacaoUserDetailsService;


// Mapeia URL, Endereços, Autoriza ou Bloqueia acessos a URL
@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {


    @Autowired
    private ImplementacaoUserDetailsService implementacaoUserDetailsService;

    @Override 
    public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers( "/v2/api-docs", "/configuration/ui", "/swagger-resources", "/configuration/security", "/swagger-ui.html", "/webjars/**","/swagger/**"); 
    }


    // Configura as solicitações de acesso pro Http
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Ativando a proteção contra usuário que não estão validados por token
    	
    	String[] blankList = {
    			"/login",
    			"/api/v1/user/register",
    			"/h2-console/*", 
    			"/swagger-ui/**",
    			"*/configuration/ui/*",
    			"/swagger-resources/**",
    			"/configuration/security/*",
    			"/webjars/*",
    			"/swagger/*"
    	};
    	
    	http
    	// H2
    	.headers().frameOptions().disable()
    	.and()
		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.disable().authorizeRequests().antMatchers(blankList).permitAll()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
    	.authorizeRequests()
    	.antMatchers(blankList).permitAll()
    	.antMatchers(HttpMethod.POST, "/api/v1/*").hasRole("ADMIN")
    	.antMatchers(HttpMethod.PUT, "/api/v1/*").hasRole("ADMIN")
    	.antMatchers(HttpMethod.DELETE, "/api/v1/*").hasRole("ADMIN")
    	.antMatchers(HttpMethod.PATCH, "/api/v1/*").hasRole("ADMIN")
    	.antMatchers(HttpMethod.GET, "/api/v1/**").permitAll()
    	.and()
		.addFilterBefore(new JWTLoginFilter("/login", authenticationManager()), UsernamePasswordAuthenticationFilter.class)
		.addFilterBefore(new JwtApiAutenticacaoFilter(), UsernamePasswordAuthenticationFilter.class)
		.authorizeRequests()
		.anyRequest()
		.authenticated();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Service que irá consultar o usuário no banco de dados
        auth.userDetailsService(implementacaoUserDetailsService)

                // Padrão de codificação de senha do usuário com BCryptPasswordEncoder
                .passwordEncoder(new BCryptPasswordEncoder());
    }

}