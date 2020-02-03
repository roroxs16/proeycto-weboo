package com.poseidonapp.prototipo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poseidonapp.prototipo.model.Rol;
import com.poseidonapp.prototipo.model.Usuario;
import com.poseidonapp.prototipo.repository.UsuarioRepository;


@Service("usuarioService")
public class UsuarioService  implements UserDetailsService, IUserService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuarioRepository.findByCorreo(username);
		
		List<GrantedAuthority> autoridades= new ArrayList<GrantedAuthority>();
		
		for(Rol rol: usuario.getRoles()) {
			autoridades.add(new SimpleGrantedAuthority(rol.getAutoridad()));
		}
		
		return new User(usuario.getCorreo(), usuario.getPassword(),true,true,true,true, autoridades);
	}

	@Override
	public void save(Usuario usuario) {
		
		usuarioRepository.save(usuario);
		
	}

	@Override
	public void saveUsuarioRoles(Long id_User, Long id_Rol) {
		  usuarioRepository.saveUsuario_Roles(id_User, id_Rol);
		
	}

}
