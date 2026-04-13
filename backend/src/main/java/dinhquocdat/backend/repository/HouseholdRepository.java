package dinhquocdat.backend.repository;

import dinhquocdat.backend.entity.Household;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HouseholdRepository extends JpaRepository<Household, Integer> {
}