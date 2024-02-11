package com.example.empl4sem2CRUD.service;

import com.example.empl4sem2CRUD.model.User;
import com.example.empl4sem2CRUD.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    /**
     * Удаление пользователя через репозиторий
     * @param id
     */
    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    /**
     * Выбор пользователя по id
     * @param id
     * @return пользователь с заданным id
     */
    public User findOne(int id){
        System.out.println("User service get id: "+id);
        return userRepository.findOne(id);
    }

    /**
     * Обновление данных пользователя через репозиторий
     * @param user
     * @return обновленный user
     */
    public User updateUser(User user){
        return userRepository.update(user);
    }
}
