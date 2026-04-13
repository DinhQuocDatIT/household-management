package dinhquocdat.backend.controller;

import dinhquocdat.backend.dto.request.LoginRequest;
import dinhquocdat.backend.dto.request.SignupRequest;
import dinhquocdat.backend.dto.response.JwtResponse;
import dinhquocdat.backend.dto.response.MessageResponse;
import dinhquocdat.backend.dto.response.UserResponse;
import dinhquocdat.backend.mapper.UserMapper;
import dinhquocdat.backend.security.jwt.JwtUtils;
import dinhquocdat.backend.security.service.UserDetailsImpl;
import dinhquocdat.backend.service.UserService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager; // Bộ máy xác thực của Spring

    @Autowired
    UserService userService; // Tầng xử lý logic User

    @Autowired
    JwtUtils jwtUtils; // Máy tạo Token

    @Autowired
    UserMapper userMapper;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        // Kiểm tra xem username hoặc email đã tồn tại chưa
        if (userService.existByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Lỗi: Username đã tồn tại!"));
        }

        // Gọi Service để tạo User mới
        userService.registerUser(signUpRequest);

        return ResponseEntity.ok(new MessageResponse("Đăng ký thành viên thành công!"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        // 2. Lấy UserDetailsImpl
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();


        UserResponse userResponse = userMapper.toResponse(userDetails);

        return ResponseEntity.ok(new JwtResponse(jwt, "Bearer", userResponse));
    }
}
