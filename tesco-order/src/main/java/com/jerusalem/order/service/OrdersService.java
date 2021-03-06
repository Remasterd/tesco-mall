package com.jerusalem.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jerusalem.common.to.SeckillOrderTo;
import com.jerusalem.common.utils.PageUtils;
import com.jerusalem.order.entity.OrdersEntity;
import com.jerusalem.order.vo.*;

import java.util.Map;
import java.util.concurrent.ExecutionException;

/****
 * 服务层接口
 * 订单
 * @author jerusalem
 * @email 3276586184@qq.com
 * @date 2020-04-09 17:49:06
 */
public interface OrdersService extends IService<OrdersEntity> {

    /**
    * 分页查询
    * @param params
    * @return
    */
    PageUtils queryPage(Map<String, Object> params);

    /***
     * 获取结算页封装信息
     * @return
     */
    OrderConfirmVo confirmOrder() throws ExecutionException, InterruptedException;

    /***
     * 提交订单
     * @param orderSubmitVo
     * @return
     */
    SubmitOrderResponseVo submitOrder(OrderSubmitVo orderSubmitVo);

    /***
     * 根据订单号查询订单信息
     * @param orderSn
     * @return
     */
    OrdersEntity getOrderByOrderSn(String orderSn);

    /***
     * 关闭订单
     * @param ordersEntity
     */
    void closeOrder(OrdersEntity ordersEntity);

    /***
     * 获取订单的支付信息
     * @param orderSn
     * @return
     */
    PayVo getPayOrder(String orderSn);

    /****
     * 分页查询订单列表及订单项
     * @param params
     * @return
     */
    PageUtils queryPageWithItem(Map<String, Object> params);

    /***
     * 处理支付回调通知
     * @param payAsyncVo
     * @return
     */
    String handlePayResult(PayAsyncVo payAsyncVo);

    /****
     * 创建秒杀订单的详细信息
     * @param seckillOrderTo
     */
    void createSeckillOrder(SeckillOrderTo seckillOrderTo);
}

