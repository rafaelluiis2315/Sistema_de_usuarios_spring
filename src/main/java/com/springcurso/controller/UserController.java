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

    @GetMapping("/cadastro")
    public String cadastro(ModelMap model) {
        model.addAttribute("user", new User());
        return "/UserAdd";
    }

    @PostMapping("/salvar")
    public String save(@ModelAttribute("user") User user, ModelMap model) {
        dao.salvar(user);
        return "redirect:/";
    }

}
