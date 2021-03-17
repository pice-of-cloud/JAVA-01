package io.lvxy.shardingjdbc.Controller;


import io.lvxy.shardingjdbc.Util.IDUtil;
import io.lvxy.shardingjdbc.pojo.BcCustomerInf;
import io.lvxy.shardingjdbc.pojo.BcCustomerLogin;
import io.lvxy.shardingjdbc.service.BcCustomerInfService;
import io.lvxy.shardingjdbc.service.BcCustomerLoginService;
import io.lvxy.shardingjdbc.service.BoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/testCust")
public class BcCustomerInfController {

    @Autowired
    private BoOrderService boOrderService;

    @Autowired
    private BcCustomerInfService bcCustomerInfService;

    @Autowired
    private BcCustomerLoginService bcCustomerLoginService;


    @PostMapping("addUserinf/{username}")
    public void testWrite(@PathVariable String username) {
        BcCustomerLogin bcCustomerLogin = bcCustomerLoginService.selectByPrimaryKeyFromMaster(821672251614035968L);
        BcCustomerInf bcCustomerInf = new BcCustomerInf();
        bcCustomerInf.setCustomerName(bcCustomerLogin.getLoginName());
        bcCustomerInf.setCustomerId(bcCustomerLogin.getCustomerId());
        bcCustomerInf.setCustomerEmail(bcCustomerLogin.getLoginName()+"@126.com");
        Byte level = 1 >> 1;
        bcCustomerInf.setCustomerLevel(level);
        bcCustomerInf.setBirthday(new Date());
        bcCustomerInf.setGender("m");
        bcCustomerInf.setIdentityCardNo("3309831876123456");
        Byte card = 10 >> 1;
        bcCustomerInf.setIdentityCardType(card);
        //bcCustomerInf.setMobilePhone(15812345678);
        bcCustomerInf.setUserMoney(new BigDecimal(1999));
        bcCustomerInf.setUserPoint(1);
        bcCustomerInfService.save(bcCustomerInf);
    }

    @RequestMapping("getUsers")
    public String testRead() {
        BcCustomerLogin bcCustomerLogin = bcCustomerLoginService.selectByPrimaryKey(821672251614035968L);
        return bcCustomerLogin.getLoginName();
    }

    @PostMapping("saveUsers/{username}")
    public void testSave(@PathVariable String username) {
        List<BcCustomerLogin> list = new ArrayList<>(1500);
        for (int i = 0; i<=1500; i++){
            BcCustomerLogin bcCustomerLogin = new BcCustomerLogin();
            bcCustomerLogin.setCustomerId(IDUtil.getRandomId());
            bcCustomerLogin.setLoginName(username+i);
            bcCustomerLogin.setPassword("09999000"+i);
            Byte stats = 10 >> 2;
            bcCustomerLogin.setUserStats(stats);
            bcCustomerLogin.setModifiedTime(new Date());
            list.add(bcCustomerLogin);
        }
        bcCustomerLoginService.insertBatch(list);
        System.out.println(bcCustomerLoginService.insertBatch(list));
    }

    @RequestMapping("saveUsers1/{username}")
    public void testSave1(@PathVariable String username) {

        for (int i = 0; i<=10; i++){
            BcCustomerLogin bcCustomerLogin = new BcCustomerLogin();
            bcCustomerLogin.setCustomerId(IDUtil.getRandomId());
            bcCustomerLogin.setLoginName(username+i);
            bcCustomerLogin.setPassword("09999000"+i);
            Byte stats = 10 >> 2;
            bcCustomerLogin.setUserStats(stats);
            bcCustomerLogin.setModifiedTime(new Date());
            bcCustomerLoginService.insert(bcCustomerLogin);
        }
    }

    @PostMapping("saveUserLogin/{username}")
    public void testSaveLogin(@PathVariable String username) {
        BcCustomerLogin bcCustomerLogin = new BcCustomerLogin();
        bcCustomerLogin.setCustomerId(IDUtil.getRandomId());
        bcCustomerLogin.setLoginName(username);
        bcCustomerLogin.setPassword("000000kk");
        Byte stats = 10 >> 2;
        bcCustomerLogin.setUserStats(stats);
        bcCustomerLogin.setModifiedTime(new Date());

        bcCustomerLoginService.insert(bcCustomerLogin);

    }
    @RequestMapping("getUserNow/{cid}")
    public String testReadFromMaster(@PathVariable long cid) {

        return bcCustomerLoginService.selectByPrimaryKeyFromMaster(821672251614035968L).toString();
    }
}
