package com.tpuhalo.secondMaven.domain.promotion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tpuhalo.secondMaven.domain.product.ConsumerProduct;
import com.tpuhalo.secondMaven.domain.product.IndustrialProduct;


@Component("tradefair")
public class TradeFair {

	@Autowired
	private IndustrialProduct industrialProduct;
	@Autowired
	private ConsumerProduct consumerProduct;

//	public TradeFair() {
//	}
//
//	 @Autowired
//	public TradeFair(IndustrialProduct industrialProduct, ConsumerProduct consumerProduct) {
//		this.industrialProduct = industrialProduct;
//		this.consumerProduct = consumerProduct;
//	}

	// @Autowired
	// public void setIndustrialProduct(IndustrialProduct industrialProduct) {
	// this.industrialProduct = industrialProduct;
	// }
	// @Autowired
	// public void setConsumerProduct(ConsumerProduct consumerProduct) {
	// this.consumerProduct = consumerProduct;
	// }

	public int declareIndustrialProductPrice(IndustrialProduct industrialProduct) {
		return industrialProduct.calculatePrice();
	}

	public int declareConsumerProductPrice(ConsumerProduct consumerProduct) {
		return consumerProduct.calculatePrice();
	}

	public String specialPromotionalPricing() {
		String priceInfo = "Industrial Product :" + declareIndustrialProductPrice(industrialProduct);
		String otherPrice = "Consumer Product :" + declareConsumerProductPrice(consumerProduct);
		return priceInfo + " \n" + otherPrice;
	}
}
