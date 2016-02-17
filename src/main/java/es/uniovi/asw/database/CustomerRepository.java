package es.uniovi.asw.database;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.logica.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}