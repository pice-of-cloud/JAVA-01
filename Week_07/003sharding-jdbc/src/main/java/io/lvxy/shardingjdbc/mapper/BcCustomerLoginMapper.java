package io.lvxy.shardingjdbc.mapper;


import io.lvxy.shardingjdbc.pojo.BcCustomerLogin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BcCustomerLoginMapper {
    int deleteByPrimaryKey(Long customerId);

    int insert(BcCustomerLogin record);

    BcCustomerLogin selectByPrimaryKey(Long customerId);

    List<BcCustomerLogin> selectAll();

    int updateByPrimaryKey(BcCustomerLogin record);
    int insertBatch(List<BcCustomerLogin> list);
}
