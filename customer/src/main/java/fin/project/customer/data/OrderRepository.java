package fin.project.customer.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("SELECT s FROM Order s WHERE s.cusId =?1")
    List<Order> findByCusId(int cusId);
}
