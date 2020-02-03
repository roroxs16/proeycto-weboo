package com.poseidonapp.prototipo.service;

import com.poseidonapp.prototipo.model.Usuario;


public interface IUserService {
	

    public void save(Usuario us);
    public void saveUsuarioRoles(int id_User, int id_Rol);
    
}
