package io.lvxy.v1.service.impl;

import io.lvxy.v1.config.database.Master;
import io.lvxy.v1.mapper.BcCustomerLoginMapper;
import io.lvxy.v1.pojo.BcCustomerLogin;
import io.lvxy.v1.service.BcCustomerLoginService;
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
    public int deleteByPrimaryKey(Integer customerId) {
        return bcCustomerLoginMapper.deleteByPrimaryKey(customerId);
    }

    @Transactional
    @Override
    public int insert(BcCustomerLogin bcCustomerLogin) {
        return bcCustomerLoginMapper.insert(bcCustomerLogin);
    }

    @Override
    public BcCustomerLogin selectByPrimaryKey(Integer customerId) {
        return bcCustomerLoginMapper.selectByPrimaryKey(customerId);
    }

    @Master
    @Override
    public BcCustomerLogin selectByPrimaryKeyFromMaster(Integer customerId) {
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
