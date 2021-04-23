package io.lvxy.service;



import io.lvxy.pojo.BoOrder;

import java.util.List;

public interface BoOrderService {
    int deleteByPrimaryKey(Long id);

    void insert(BoOrder record);

    BoOrder selectByPrimaryKey(Long id);

    List<BoOrder> selectAll();

    int updateByPrimaryKey(BoOrder record);
    BoOrder selectByCustomerId(Long customerId);
}