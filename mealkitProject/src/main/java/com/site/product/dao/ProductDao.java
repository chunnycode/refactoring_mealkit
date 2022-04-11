package com.site.product.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.site.product.model.ProductVo;
import com.site.product.model.ReviewVo;
import com.site.store.model.StoreVo;

@Mapper
public interface ProductDao {

	int productRegister(ProductVo productVo);

	int productCountSelect(String searchWord, String classification, String cook_time, String category);

	ArrayList<ProductVo> productList(int startRow, int endRow, String searchWord, String classification,
			String cook_time, String category);

	ProductVo productOneSelect(String id);

	StoreVo storeOneSelect(String id);

	int productModify(ProductVo productVo);

	int productDelete(String id);

	void productRateUpdate(int product_id);

	ArrayList<ProductVo> productTopList();

	int productReviewCount(String id);

	ArrayList<ReviewVo> reviewProductList(String id);
}
