package com.src.ingtradeapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.src.ingtradeapp.model.ProductDetails;
import com.src.ingtradeapp.model.Products;
import com.src.ingtradeapp.response.JSONResponse;
import com.src.ingtradeapp.services.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductDetailController {

	@Autowired
	JSONResponse response;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/{product_id}")
	public ProductDetails  getStocks(@PathVariable("product_id") Long id) {
		ProductDetails res = productService.getProductDetailsById(id);
		if(res == null) {
			res = new ProductDetails();
			res.setStatus(false);
		} else {
			res.setStatus(true);
		}
		return res;
	}
}
