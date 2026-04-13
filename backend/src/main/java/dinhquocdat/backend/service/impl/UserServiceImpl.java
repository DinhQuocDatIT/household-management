package dinhquocdat.backend.service.impl;


import dinhquocdat.backend.dto.request.CreateUserRequest;
import dinhquocdat.backend.dto.request.SignupRequest;
import dinhquocdat.backend.dto.request.UpdateUserRequest;
import dinhquocdat.backend.dto.response.UserResponse;
import dinhquocdat.backend.entity.Role;
import dinhquocdat.backend.entity.User;
import dinhquocdat.backend.mapper.UserMapper;
import dinhquocdat.backend.repository.UserRepository;
import dinhquocdat.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserResponse create(CreateUserRequest request) {

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        }

        User user = userMapper.toUser(request);

        // set default role nếu null
        if (user.getRole() == null) {
            user.setRole(Role.ROLE_USER);
        }

        userRepository.save(user);

        return userMapper.toResponse(user);
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toResponse)
                .toList();
    }

    @Override
    public UserResponse getById(Integer id) {
        User user = findUserById(id);
        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse update(Integer id, UpdateUserRequest request) {
        User user = findUserById(id);

        if (request.getPassword() != null) {
            user.setPassword(request.getPassword());
        }

        if (request.getRole() != null) {
            user.setRole(request.getRole());
        }

        userRepository.save(user);

        return userMapper.toResponse(user);
    }

    @Override
    public void delete(Integer id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }

    @Override
    public boolean existByUsername(String username) {
        return  userRepository.existsByUsername(username);


    }

    @Override
    public User registerUser(SignupRequest request) {
        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.ROLE_USER);
        User userSaved = userRepository.save(user);
        return userSaved;
    }

    private User findUserById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}