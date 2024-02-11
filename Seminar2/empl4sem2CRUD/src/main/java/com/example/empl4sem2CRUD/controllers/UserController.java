package com.example.empl4sem2CRUD.controllers;

import com.example.empl4sem2CRUD.model.User;
import com.example.empl4sem2CRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();


        model.addAttribute("users", users);
        return "user-list";
        //return "home.html";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    /**
     * Перехват команды на удаление студента от браузера
     * @param id
     * @return список всех пользователей из таблицы userTable
     */
    @GetMapping("user-delete/{id}")
    String deleteUser(@PathVariable("id") int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    /**
     * Перехват команды на выбор пользователя по id от браузера
     * @param id
     * @param model
     * @return страницу редактирования пользователя
     */
    @GetMapping("/user-update/{id}")
    String findOne(@PathVariable("id") int id, Model model){
        User user = userService.findOne(id);
        model.addAttribute("user", user);
        return "user-update";
    }

    /**
     * Перехват команды на редактирование данных пользователя
     * @param user
     * @return список всех пользователей из таблицы userTable
     */
    @PostMapping("/user-update")
    String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/users";
    }
}
