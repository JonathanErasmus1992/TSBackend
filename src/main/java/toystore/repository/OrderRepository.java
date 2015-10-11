package toystore.repository;

import org.springframework.data.repository.CrudRepository;

import toystore.domain.Orders;

public interface OrderRepository extends CrudRepository<Orders,Long> {
}
