package br.com.jonathan.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.jonathan.model.Product;
import br.com.jonathan.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductRest {

	@Autowired
	private ProductService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView findAll() {
		ModelAndView view = new ModelAndView("/produto");
		view.addObject("products", service.findAll());
		return view;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add(Product product) {
		ModelAndView view = new ModelAndView("/produtoCadastro");
		view.addObject("product", product);
		return view;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") Long id) {
		return add(service.findOne(id));
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") Long id) {
		service.delete(id);
		return findAll();
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@Valid Product product, BindingResult result) {
		if (result.hasErrors()) {
			return add(product);
		}
		service.save(product);
		return findAll();
	}

}