package pl.matrasbartosz.springhardwarestore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.matrasbartosz.springhardwarestore.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
