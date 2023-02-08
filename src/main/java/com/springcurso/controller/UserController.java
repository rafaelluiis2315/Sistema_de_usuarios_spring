package com.springcurso.controller;

import com.springcurso.dao.UserDao;
import com.springcurso.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    private UserDao dao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String HelloWorld(ModelMap model){
        model.addAttribute("users", dao.getTodos());
        model.addAttribute("user", new User());
        return "/UserList";
    }

    @PostMapping("/salvar")
    public String save(@ModelAttribute("user") User user, ModelMap model) {
        dao.salvar(user);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String preUpdate(@PathVariable("id") Long id, ModelMap model) {
        User user = dao.getId(id);
        model.addAttribute("user", user);
        model.addAttribute("action", "update");
        return "/UserAdd";
    }

    @PostMapping("/update")
    public String Update(@ModelAttribute("user") User user, ModelMap model) {
        dao.editar(user);
        return "redirect:/";
    }
}
