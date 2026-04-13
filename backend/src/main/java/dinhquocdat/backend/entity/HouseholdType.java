package dinhquocdat.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "household_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HouseholdType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
}