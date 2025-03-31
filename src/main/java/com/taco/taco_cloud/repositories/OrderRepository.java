package com.taco.taco_cloud.repositories;

import com.taco.taco_cloud.models.TacoOrder;

public interface OrderRepository {

    TacoOrder save(TacoOrder tacoOrder);


}
