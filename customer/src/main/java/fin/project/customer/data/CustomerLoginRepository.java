package fin.project.customer.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerLoginRepository extends JpaRepository<CustomerLogin, Integer> {

//    @Query("select c1_0.password,c1_0.username from customer_login_credentials c1_0 where c1_0.username=? and c1_0.password=?")
    Optional<CustomerLogin> findByUsernameAndPassword(String username, String password);
}
