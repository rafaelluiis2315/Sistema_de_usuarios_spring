package com.springcurso.dao;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.springcurso.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    private static List<User> userList;

    public UserDaoImpl() {
        createUserList();
    }

    private List<User> createUserList() {
        if (userList == null) {
            userList = new LinkedList<>();
            userList.add(new User(System.currentTimeMillis()+1L, "Ana", "da Silva"));
            userList.add(new User(System.currentTimeMillis()+2L, "Luiz", "dos Santos"));
            userList.add(new User(System.currentTimeMillis()+3L, "Mariana", "Mello"));
            userList.add(new User(System.currentTimeMillis()+4L, "Caren", "Pereira"));
            userList.add(new User(System.currentTimeMillis()+5L, "Sonia", "Fagundes"));
            userList.add(new User(System.currentTimeMillis()+6L, "Norberto", "de Souza"));
        }
        return userList;
    }

    @Override
    public void salvar(User user) {
        user.setId(System.currentTimeMillis());
        userList.add(user);
    }

    @Override
    public void editar(User user) {
        userList.stream()
                .filter((u) -> u.getId().equals(user.getId()))
                .forEach((u) -> {
                    u.setNome(user.getNome());
                    u.setSobrenome(user.getSobrenome());
                });
    }

    @Override
    public void excluir(Long id) {
        userList.removeIf((u) -> u.getId().equals(id));
    }

    @Override
    public User getId(Long id) {
        return userList.stream()
                .filter((u) -> u.getId().equals(id))
                .collect(Collectors.toList()).get(0);
    }

    @Override
    public List<User> getTodos() {
        return userList;
    }
}
