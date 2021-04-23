package io.lvxy.Controller;


import io.lvxy.Util.IDUtil;
import io.lvxy.pojo.BoOrder;
import io.lvxy.service.BoOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@RequestMapping("/testCust")
public class BcCustomerInfController {

    @Autowired
    private BoOrderService boOrderService;

    @RequestMapping("addOrder/{userId}")
    public void addOrder(@PathVariable("userId") Long userId){

        BoOrder boOrder = new BoOrder();
        //boOrder.setOrderId(IDUtil.getRandomId());
        boOrder.setOrderType(1);
        boOrder.setOrderSn(IDUtil.getRandomId()+"test");
        boOrder.setCustomerId(userId);
        boOrder.setConfirmStatus(1);
        boOrder.setCreateTime(new Date(System.currentTimeMillis()));
        boOrder.setCommentTime(new Date(System.currentTimeMillis()));

        boOrder.setDeleteStatus(0);
        boOrder.setDeliveryCompany("DeliveryCompany");
        boOrder.setDeliverySn("27364783265345873");
        boOrder.setDeliveryTime(new Date(System.currentTimeMillis()));

        boOrder.setFreightAmount(new BigDecimal(100));

        boOrder.setModifyTime(new Date(System.currentTimeMillis()-10000));
        boOrder.setNote("test");

        boOrder.setPayAmount(new BigDecimal(98));
        boOrder.setPaymentTime(new Date(System.currentTimeMillis()));
        boOrder.setPayType(1);

        boOrder.setReceiverCity("北京");
        boOrder.setReceiverDetailAddress("1111111");
        boOrder.setReceiverName("海淀");
        boOrder.setReceiverPhone("1901111111");
        boOrder.setReceiverRegion("ReceiverRegion");
        boOrder.setReceiverProvince("beijing");
        boOrder.setReceiveTime(new Date(System.currentTimeMillis()+10000));
        boOrder.setReceiverPostCode("101010");

        boOrder.setSourceType(1);
        boOrder.setStatus(1);

        boOrder.setTotalAmount(new BigDecimal(100.00));

        boOrder.setUserUsername(userId.toString()+":userId");

        boOrder.setAutoConfirmDay(1);
        boOrder.setSourceType(1);
        boOrderService.insert(boOrder);

    }

    @RequestMapping("getOrderInfo/{userId}")
    public void getOrder(@PathVariable("userId") Long userId){
        boOrderService.selectByCustomerId(userId);
    }

}
