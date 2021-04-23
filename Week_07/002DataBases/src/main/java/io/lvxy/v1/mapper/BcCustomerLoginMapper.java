package io.lvxy.v1.mapper;

import io.lvxy.v1.pojo.BcCustomerLogin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BcCustomerLoginMapper {
    int deleteByPrimaryKey(Integer customerId);

    int insert(BcCustomerLogin record);

    BcCustomerLogin selectByPrimaryKey(Integer customerId);

    List<BcCustomerLogin> selectAll();

    int updateByPrimaryKey(BcCustomerLogin record);
    int insertBatch(List<BcCustomerLogin> list);
}
