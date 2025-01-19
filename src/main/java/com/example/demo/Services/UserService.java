package com.example.demo.Services;

import com.example.demo.Tables.Users;
import com.example.demo.Repositoryes.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UsersRepository userRepository;

    @Autowired
    public UserService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create
    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    // Read all
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    // Read by ID
    public Optional<Users> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Update
    public Users updateUser(Long id, Users userDetails) {
        Users existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(userDetails.getName());
        existingUser.setPhone(userDetails.getPhone());
        existingUser.setBlood_type(userDetails.getBlood_type());
        existingUser.setAllergy(userDetails.getAllergy());
        existingUser.congenital_diseases(userDetails.congenital_diseases());
        existingUser.setBirthdate(userDetails.getBirthdate());
        return userRepository.save(existingUser);
    }

    // Delete
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
