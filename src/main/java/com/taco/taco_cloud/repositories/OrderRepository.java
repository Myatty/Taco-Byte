package com.taco.taco_cloud.repositories;

import com.taco.taco_cloud.models.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

}
