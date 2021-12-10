package com.reto2.reto2.Repository;

import com.reto2.reto2.Interface.UserCrudRepository;
import com.reto2.reto2.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }

    public List<User> listar(){
        return userCrudRepository.findAll();
    }

    public boolean emailExiste(String email){
        Optional<User> usuario = userCrudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }

    public Optional<User> autenticarUser(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    public User create(User u){
        return userCrudRepository.save(u);
    }

    public User update(User u){
        return userCrudRepository.save(u);
    }

    public void delete(User user){
        userCrudRepository.delete(user);
    }


}
