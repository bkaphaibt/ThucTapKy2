package springhibernate.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springhibernate.dao.ProductDAO;
import springhibernate.entities.Product;

@Controller
public class ProductController {
	@Autowired
	private ProductDAO productDAO;
	
	@InitBinder
	public void initBinder(WebDataBinder data) {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		data.registerCustomEditor(Date.class, new CustomDateEditor(sf,true));
	}
	
	@RequestMapping(value = {"/","/listP"})
	public String listProducts(Model model) {
		List<Product> products = productDAO.getProducts();
		model.addAttribute("list", products);
		return "listProducts";
	}
	
	@RequestMapping("/initInsertProduct")
	public String initInsertProduct(Model model) {
		Product p = new Product();
		model.addAttribute("p", p);
		return  "insertProduct";
	}
	
	@RequestMapping("/insertProduct")
	public String insertProduct(@ModelAttribute("p")Product p, Model model) {
		boolean bl = productDAO.insertProduct(p);
		if(bl) {
			return "redirect:/listP";
		}else {
			model.addAttribute("error", "Insert failed!");
			model.addAttribute("p", p);
			return  "insertProduct";
		}
	}
	
	@RequestMapping("/detailProduct")
	public String detailProduct(@RequestParam("proId")Integer proId, Model model) {
		Product product = productDAO.getProductById(proId);
		model.addAttribute("p", product);
		return "viewProduct";
	}
	
	@RequestMapping("/initUpdateProduct")
	public String initUpdateProduct(@RequestParam("proId")Integer proId, Model model) {
		Product product = productDAO.getProductById(proId);
		model.addAttribute("p", product);
		return "updateProduct";
	}
	
	@RequestMapping("/updateProduct")
	public String updateProduct(@ModelAttribute("p")Product p, Model model) {
		boolean bl = productDAO.updateProduct(p);
		if(bl) {
			return "redirect:/listP";
		}else {
			model.addAttribute("error", "Update failed!");
			model.addAttribute("p", p);
			return  "updateProduct";
		}
	}
	
	@RequestMapping("/deleteProduct")
	public String deleteProduct(@RequestParam("proId")Integer proId, Model model) {
		
		Product product = productDAO.getProductById(proId);
		String name = "";
		if(product==null)
			name = proId+"";
		else
			name = product.getProName();
		
		boolean deleteProduct = productDAO.deleteProduct(proId);
		if(deleteProduct) {
			model.addAttribute("success", "Delete successfully for product: "+name);
		}else {
			model.addAttribute("error", "Delete failed for product: "+name);
		}
		
		List<Product> products = productDAO.getProducts();
		model.addAttribute("list", products);
		return "listProducts";
	}
	
	@RequestMapping("/searchProductByName")
	public String searchProductByName(@RequestParam("proName")String proName, Model model) {
		List<Product> list = productDAO.getProductsByName(proName);
		model.addAttribute("list", list);
		return "listProducts";
	}
}
