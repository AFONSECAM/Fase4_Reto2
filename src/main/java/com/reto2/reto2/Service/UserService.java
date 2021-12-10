package com.reto2.reto2.Service;

import com.reto2.reto2.Models.User;
import com.reto2.reto2.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> listar(){
        return userRepository.listar();
    }

    public boolean emailExiste(String email){
        return userRepository.emailExiste(email);
    }

    public User autenticarUser(String email, String passowrd){
        Optional<User> usuario = userRepository.autenticarUser(email, passowrd);
        if(usuario.isEmpty()){
            return new User();
        }else{
            return usuario.get();
        }
    }

    public User create(User u){
        if(u.getId() == null){
            return u;
        }else{
            Optional<User> ou = userRepository.getUser(u.getId());
            if(ou.isEmpty()){
                if(emailExiste(u.getEmail()) == false){
                    return userRepository.create(u);
                }else{
                    return u;
                }
            }else{
                return u;
            }
        }
    }

    public User update(User u){
        if(u.getId() != null){
            Optional<User> ou = userRepository.getUser(u.getId());
            if(!ou.isEmpty()){
                if(u.getIdentification() != null){
                    ou.get().setIdentification(u.getIdentification());
                }
                if(u.getName() != null){
                    ou.get().setName(u.getName());
                }
                if(u.getAddress() != null){
                    ou.get().setAddress(u.getAddress());
                }
                if(u.getCellPhone() != null){
                    ou.get().setCellPhone(u.getCellPhone());
                }
                if(u.getEmail() != null){
                    ou.get().setEmail(u.getEmail());
                }
                if(u.getPassword() != null){
                    ou.get().setPassword(u.getPassword());
                }
                if(u.getZone() != null){
                    ou.get().setZone(u.getZone());
                }
                userRepository.update(ou.get());
                return ou.get();
            }else{
                return u;
            }
        }else{
            return u;
        }
    }

    public boolean delete(Integer id){
        Boolean aBoolean = userRepository.getUser(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
