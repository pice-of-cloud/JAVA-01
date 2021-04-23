package io.lvxy.mapper;

import io.lvxy.pojo.BoOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoOrderMapper {
    int deleteByPrimaryKey(Long orderId);

    void insert(BoOrder record);

    BoOrder selectByPrimaryKey(Long orderId);

    List<BoOrder> selectAll();

    int updateByPrimaryKey(BoOrder record);
    BoOrder selectByCustomerId(Long customerId);
}