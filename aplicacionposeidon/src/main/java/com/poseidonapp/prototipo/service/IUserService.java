package com.poseidonapp.prototipo.service;

import com.poseidonapp.prototipo.model.Usuario;


public interface IUserService {
	

    public void save(Usuario us);
    public void saveUsuarioRoles(Long id_User, Long id_Rol);
    
}
