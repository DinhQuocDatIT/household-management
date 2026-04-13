package dinhquocdat.backend.service;


import dinhquocdat.backend.dto.request.CreateUserRequest;
import dinhquocdat.backend.dto.request.SignupRequest;
import dinhquocdat.backend.dto.request.UpdateUserRequest;
import dinhquocdat.backend.dto.response.UserResponse;
import dinhquocdat.backend.entity.User;

import java.util.List;

public interface UserService {

    UserResponse create(CreateUserRequest request);

    List<UserResponse> getAll();

    UserResponse getById(Integer id);

    UserResponse update(Integer id, UpdateUserRequest request);

    void delete(Integer id);
    public  boolean existByUsername(String username);
     public  User registerUser(SignupRequest request);

}