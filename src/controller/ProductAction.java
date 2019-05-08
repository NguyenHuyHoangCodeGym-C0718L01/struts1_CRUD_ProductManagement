package controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.MappingDispatchAction;

import service.*;


public class ProductAction extends MappingDispatchAction{
	
	public ActionForward addProduct(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		return mapping.findForward("addProduct");
	}
	
	public ActionForward editProduct(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		int idProduct = Integer.valueOf(request.getParameter("idProd"));
		ProductService productService = new ProductService();
		ProductDB product = productService.getProductById(idProduct);
		request.setAttribute("product", product);
		
		return mapping.findForward("editProduct");
	}
	
	public ActionForward getHomePage(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		ProductService productService = new ProductService();
		List<ProductDB> list = productService.getListProducts();
		request.setAttribute("list", list);
		return mapping.findForward("getHomePage");
	}
	
	public ActionForward proAddProduct(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		Product product = (Product)form;
		ProductService productService = new ProductService();
		ProductDB productDB = new ProductDB(0, product.getName(), Integer.valueOf(product.getPrice()), product.getDescription());
		int result = productService.saveProduct(productDB);
		if(result<=0){
			request.setAttribute("message", "Something wrong! Cannot add product");
		}else{
			request.setAttribute("message", "Add new product successfully!");
		}
		
		return mapping.findForward("proAddProduct");
	}
	
	public ActionForward proEditProduct(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		Product product = (Product) form;
		ProductService productService = new ProductService();
		ProductDB productDB = new ProductDB(Integer.valueOf(product.getId()), product.getName(), Integer.valueOf(product.getPrice()), product.getDescription());
		int result = productService.updateProduct(productDB);
		if(result <= 0){
			request.setAttribute("message", "Something wrong! Cannot edit product");
		}else{
			request.setAttribute("message", "Edit product sucessfully!");
		}
		productService = new ProductService();
		List<ProductDB> list = productService.getListProducts();
		request.setAttribute("list", list);
		return mapping.findForward("proEditProduct");
	}
	
	public ActionForward deleteProduct(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		int idProduct = Integer.valueOf(request.getParameter("idProd"));
		ProductService productService = new ProductService();
		int result = productService.deleteProduct(idProduct);
		if(result<=0){
			request.setAttribute("message", "Something wrong! Cannot delete product");
		}else{
			request.setAttribute("message", "Delete product sucessfully!");
		}
		productService = new ProductService();
		List<ProductDB> list = productService.getListProducts();
		request.setAttribute("list", list);
		return mapping.findForward("deleteProduct");
	}
	
	
}
