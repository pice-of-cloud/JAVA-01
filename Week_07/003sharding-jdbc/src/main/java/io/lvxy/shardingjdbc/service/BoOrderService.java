package io.lvxy.shardingjdbc.service;


import io.lvxy.shardingjdbc.pojo.BoOrder;

import java.util.List;

public interface BoOrderService {
    int deleteByPrimaryKey(Long id);

    int insert(BoOrder record);

    BoOrder selectByPrimaryKey(Long id);

    List<BoOrder> selectAll();

    int updateByPrimaryKey(BoOrder record);
}