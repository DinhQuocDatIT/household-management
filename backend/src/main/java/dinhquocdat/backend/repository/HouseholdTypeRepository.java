package dinhquocdat.backend.repository;


import dinhquocdat.backend.entity.HouseholdType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdTypeRepository extends JpaRepository<HouseholdType, Integer> {
}