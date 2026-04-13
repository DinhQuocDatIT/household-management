package dinhquocdat.backend.controller;

import dinhquocdat.backend.dto.request.CreateUserRequest;
import dinhquocdat.backend.dto.request.UpdateUserRequest;
import dinhquocdat.backend.dto.response.UserResponse;
import dinhquocdat.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // CREATE
    @PostMapping
    public UserResponse create(@RequestBody CreateUserRequest request) {
        return userService.create(request);
    }

    // READ ALL
    @GetMapping
    public List<UserResponse> getAll() {
        return userService.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public UserResponse getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Integer id,
                               @RequestBody UpdateUserRequest request) {
        return userService.update(id, request);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        userService.delete(id);
    }
}