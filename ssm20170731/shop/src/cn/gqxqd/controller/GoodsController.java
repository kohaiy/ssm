package cn.gqxqd.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gqxqd.service.GoodsService;
import cn.gqxqd.util.ShopResult;

@Controller
@RequestMapping("goods")
public class GoodsController {

	@Resource
	private GoodsService goodsService;

	@RequestMapping("list")
	@ResponseBody
	public ShopResult getGoodsList() {
		return goodsService.getGoodsList();
	}
}