package com.crio.qcontest.services;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.crio.qcontest.constants.UserOrder;
import com.crio.qcontest.entities.User;
import com.crio.qcontest.repositories.IUserRepository;

public class UserService{

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Complete the implementation of createUser method
    // Implementation must take care of the following cases:-
    // 1) Create and store user in the repository.

    public User createUser(String name) {
        // Creating a user with the given String 
        User user=new User(name);

        // Storing the user with the help of IUserRepository
        return userRepository.save(user);
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Complete the implementation of getAllUser method
    // Implementation must take care of the following cases:-
    // 1) Get all the users in ascending Order w.r.t score.
    // 2) Get all the users in descending Order w.r.t score.

    public List<User> getUsers(UserOrder userOrder) {
     

        if( UserOrder.SCORE_ASC.equals(userOrder) )
        return userRepository.findAll().stream().sorted(
               (c1, c2) -> c1.getTotalScore() - c2.getTotalScore() ).collect(Collectors.toList() );

       return userRepository.findAll().stream().sorted(
        (c1, c2) -> c2.getTotalScore() - c1.getTotalScore() ).collect(Collectors.toList() ); 
    } 
}
