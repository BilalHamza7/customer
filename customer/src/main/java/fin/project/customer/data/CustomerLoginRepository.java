package fin.project.customer.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerLoginRepository extends JpaRepository<CustomerLogin, Integer> {

    Optional<CustomerLogin> findByUsernameAndPassword(String username, String password);
}
