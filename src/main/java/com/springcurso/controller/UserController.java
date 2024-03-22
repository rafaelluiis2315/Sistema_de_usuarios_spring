package com.springcurso.controller;

import com.springcurso.dao.UserDao;
import com.springcurso.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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
    public String save(@ModelAttribute("user") User user, ModelMap model, RedirectAttributes attr) {
        dao.salvar(user);
        attr.addFlashAttribute("menssage", "Usuario salvo com sucesso.");
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
    public String Update(@ModelAttribute("user") User user, ModelMap model, RedirectAttributes attr) {
        dao.editar(user);
        attr.addFlashAttribute("menssage", "Usuario atualizado com sucesso.");
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes attr){
        dao.excluir(id);
        attr.addFlashAttribute("menssage", "Usuario excluido com sucesso.");
        return "redirect:/";
    }
}
