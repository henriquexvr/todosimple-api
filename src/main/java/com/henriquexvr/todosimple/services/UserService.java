package com.henriquexvr.todosimple.services;

import com.henriquexvr.todosimple.model.Task;
import com.henriquexvr.todosimple.model.User;
import com.henriquexvr.todosimple.repositories.TaskRepository;
import com.henriquexvr.todosimple.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private TaskRepository taskRepository;

    public User findById(Long id){
        Optional<User> user = this.userRepository.findById(id);
        return  user.orElseThrow(() -> new RuntimeException("Usuario não encontrado! Id" + id + ", Tipo: " + User.class.getName()));
    }

    @Transactional
    public User create (User obj){
        obj.setId(null);
        obj = this.userRepository.save(obj);
        this.taskRepository.saveAll(obj.getTasks());
        return obj;
    }

    @Transactional
    public User update (User obj){
        User newObj = findById(obj.getId());
        newObj.setPassword(obj.getPassword());
        return this.userRepository.save(newObj);
    }

    public void delete(Long id){
        findById(id);
        try{
            this.userRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possivel pois tem entidade relacionadas.");
        }
    }
}

