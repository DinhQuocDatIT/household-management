package dinhquocdat.backend.dto.response;

import dinhquocdat.backend.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor // Tạo Constructor chứa tất cả các tham số (Sửa lỗi bạn gặp)
@NoArgsConstructor  // Tạo Constructor trống
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private UserResponse user;

    // Constructor tùy chỉnh (vì mình không muốn truyền chữ "Bearer" mỗi lần khởi tạo)
    public JwtResponse(String accessToken, Integer id, String username, Role roles, LocalDateTime createdAt) {
        this.token = accessToken;
        this.type = "Bearer";
        // Tự động tạo gói UserReponse từ các tham số truyền vào
        this.user = new UserResponse(id, username, roles.name(),createdAt);
    }
}