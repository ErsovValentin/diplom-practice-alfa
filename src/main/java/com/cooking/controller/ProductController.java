package com.cooking.controller;


import com.cooking.model.Product;
import com.cooking.model.addition.ProductMeasure;
import com.cooking.model.addition.ProductType;
import com.cooking.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.ws.rs.Path;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/products")
    public String listOfProducts(Model model, ModelAndView modelAndView)
    {
        model.addAttribute("listOfProducts",productService.getAllProducts());
        model.addAttribute("product", new Product());
        modelAndView.addObject("productType", ProductType.values());
        modelAndView.addObject("productMeasure", ProductMeasure.values());
        return "/productAdmin/products";
    }

    @RequestMapping(value = "product/addProduct" , method = RequestMethod.POST)
    public String productAdd(@ModelAttribute("product") Product product)
    {
        if (product.getId() == 0)
        {productService.addProduct(product);}
        else
        {productService.updateProduct(product);}

        return "redirect:/products";
    }

    @RequestMapping(value = "/updateProduct/{id}")
    public String updateProduct(@PathVariable("id") int productId, Model model)
    {
        model.addAttribute("listOfProducts",productService.getAllProducts());
        model.addAttribute("product", productService.getProductById(productId));

        return "/productAdmin/products";
    }

    @RequestMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") int productId)
    {
        productService.deleteProduct(productService.getProductById(productId));
        return "redirect:/products";
    }
}
