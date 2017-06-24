package com.modulo.promoVentas.controller;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.modulo.promoVentas.model.Promocion;
import com.modulo.promoVentas.service.PromocionService;

@Controller
@RequestMapping("/promocion")
public class PromocionController {

	@Autowired
	PromocionService promocionService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void list() {
		
		Collection<Promocion> promociones = promocionService.list();
		
		for (Promocion promocion : promociones) {
			System.out.println(promocion.getPr_nombre());
			System.out.println(promocion.getPr_codigoPromocion());
		}
	}
}
