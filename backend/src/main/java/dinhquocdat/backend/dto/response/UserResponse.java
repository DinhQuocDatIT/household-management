package dinhquocdat.backend.dto.response;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserResponse {
    private Integer id;
    private String username;
    private String role;
    private LocalDateTime createdAt;
}