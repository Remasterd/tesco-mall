package com.jerusalem.goods.controller.server;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.jerusalem.goods.entity.SkuInfoEntity;
import com.jerusalem.goods.service.SkuInfoService;
import com.jerusalem.common.utils.PageUtils;
import com.jerusalem.common.utils.R;

/****
 * 控制层
 * sku信息
 * @author jerusalem
 * @email 3276586184@qq.com
 * @date 2020-04-09 14:48:19
 */
@RestController
@RequestMapping("goods/sku/info")
public class SkuInfoController {

    @Autowired
    private SkuInfoService skuInfoService;

    /****
     * 根据id查询商品的价格
     * @param skuId
     * @return
     */
    @GetMapping("{skuId}/price")
    public BigDecimal getPrice(@PathVariable("skuId") Long skuId){
        SkuInfoEntity skuInfo = skuInfoService.getById(skuId);
        BigDecimal price = skuInfo.getPrice();
        return price;
    }

    /***
    * 根据分类、品牌、价格、关键词进行分页查询
    * @param params
    * @return
    */
    @GetMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = skuInfoService.queryPageByCondition(params);
        return R.ok().put("page", page);
    }

    /***
    * 获取sku的详细信息
    * @return
    */
    @GetMapping("/info/{skuId}")
    public R info(@PathVariable("skuId") Long skuId){
		SkuInfoEntity skuInfo = skuInfoService.getById(skuId);
        return R.ok().put("skuInfo", skuInfo);
    }








    /***
    * 修改
    * @return
    */
    @RequestMapping("/update")
    public R update(@RequestBody SkuInfoEntity skuInfo){
		skuInfoService.updateById(skuInfo);

        return R.ok();
    }

    /***
    * 删除
    * @return
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] skuIds){
		skuInfoService.removeByIds(Arrays.asList(skuIds));

        return R.ok();
    }
}
