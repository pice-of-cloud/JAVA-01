package io.lvxy.shardingjdbc.service.impl;

import io.lvxy.shardingjdbc.mapper.BcCustomerLoginMapper;
import io.lvxy.shardingjdbc.pojo.BcCustomerLogin;
import io.lvxy.shardingjdbc.service.BcCustomerLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BcCustomerLoginServiceImpl implements BcCustomerLoginService {

    @Autowired
    BcCustomerLoginMapper bcCustomerLoginMapper;

    @Transactional
    @Override
    public int deleteByPrimaryKey(Long customerId) {
        return bcCustomerLoginMapper.deleteByPrimaryKey(customerId);
    }

    @Transactional
    @Override
    public int insert(BcCustomerLogin bcCustomerLogin) {
        return bcCustomerLoginMapper.insert(bcCustomerLogin);
    }

    @Override
    public BcCustomerLogin selectByPrimaryKey(Long customerId) {
        return bcCustomerLoginMapper.selectByPrimaryKey(customerId);
    }


    @Override
    public BcCustomerLogin selectByPrimaryKeyFromMaster(Long customerId) {
        return bcCustomerLoginMapper.selectByPrimaryKey(customerId);
    }

    @Override
    public List<BcCustomerLogin> selectAll() {
        return bcCustomerLoginMapper.selectAll();
    }

    @Transactional
    @Override
    public int updateByPrimaryKey(BcCustomerLogin bcCustomerLogin) {
        return updateByPrimaryKey(bcCustomerLogin);
    }

    @Transactional
    @Override
    public int insertBatch(List<BcCustomerLogin> list) {
        return bcCustomerLoginMapper.insertBatch(list);
    }
}
