package com.medev.customer_service.Entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "full", types = { Customer.class })
interface CustomerProjection extends Projection {
    String getId();
    String getName();
    String getEmail();
}
