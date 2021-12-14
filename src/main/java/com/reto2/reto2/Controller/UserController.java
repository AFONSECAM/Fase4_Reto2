package com.reto2.reto2.Controller;

import com.reto2.reto2.Models.User;
import com.reto2.reto2.Service.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> listarUsuarios(){
        return userService.listar();
    }

    @GetMapping("/emailexist/{email}")
    public boolean emailExiste(@PathVariable(name = "email") String email){
        return userService.emailExiste(email);
    }

    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable(name = "email") String email, @PathVariable(name = "password") String password){
        return userService.autenticarUser(email, password);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(name = "id") Integer id){
        userService.delete(id);
    }
}
