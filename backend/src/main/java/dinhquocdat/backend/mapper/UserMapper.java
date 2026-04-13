package dinhquocdat.backend.mapper;

import dinhquocdat.backend.dto.request.CreateUserRequest;
import dinhquocdat.backend.dto.request.SignupRequest;
import dinhquocdat.backend.dto.response.UserResponse;
import dinhquocdat.backend.entity.User;
import dinhquocdat.backend.security.service.UserDetailsImpl;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface UserMapper {

    // CreateUserRequest -> User
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    User toUser(CreateUserRequest request);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "role", constant = "ROLE_USER")
    User toUser(SignupRequest request);

    @Mapping(target = "role", source = "role") // Enum -> String
    UserResponse toResponse(User user);
    // UserDetailsImpl -> Response
    @Mapping(target = "role", expression = "java(userDetails.getRole().name())")
    @Mapping(target = "createdAt", ignore = true) // vì UserDetailsImpl không có
    UserResponse toResponse(UserDetailsImpl userDetails);
}