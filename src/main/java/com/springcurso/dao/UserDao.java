package com.springcurso.dao;


import com.springcurso.model.User;

import java.util.List;

public interface UserDao{

    void salvar(User user);

    void editar(User user);

    void excluir(Long id);

    User getId(Long id);

    List<User> getTodos();
}
