package io.lvxy.shardingjdbc.service;


import io.lvxy.shardingjdbc.pojo.BcCustomerLogin;

import java.util.List;

public interface BcCustomerLoginService {
    int deleteByPrimaryKey(Long customerId);

    int insert(BcCustomerLogin record);

    BcCustomerLogin selectByPrimaryKey(Long customerId);

    BcCustomerLogin selectByPrimaryKeyFromMaster(Long customerId);

    List<BcCustomerLogin> selectAll();

    int updateByPrimaryKey(BcCustomerLogin record);

    int insertBatch(List<BcCustomerLogin> list);
}