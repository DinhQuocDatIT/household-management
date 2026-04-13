package dinhquocdat.backend.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "household")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Household {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String address;

    @ManyToOne
    @JoinColumn(name = "household_type_id")
    private HouseholdType householdType;

    @OneToOne
    @JoinColumn(name = "head_member_id")
    private Member headMember;

    private Boolean active;

    private LocalDateTime createdAt;
    @PrePersist
    public void handleBeforeCreate() {
        this.createdAt = LocalDateTime.now();
    }
}