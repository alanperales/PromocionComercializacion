package com.modulo.promoVentas.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.servlet.ServletContext;

import com.modulo.promoVentas.model.Producto;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.modulo.promoVentas.service.ProductoServiceImpl;
import com.modulo.promoVentas.service.ProductoService;
import javax.faces.convert.Converter;

@FacesConverter("productoConverter")
public class ProductoConverter implements Converter{
	
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                ApplicationContext ctx = WebApplicationContextUtils
                        .getRequiredWebApplicationContext((ServletContext) FacesContext
                                .getCurrentInstance().getExternalContext()
                                .getContext());
            	ProductoService service = (ProductoServiceImpl) ctx.getBean("productoServiceImpl");
                return service.getProducto(Integer.parseInt(value));   
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }
 
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((Producto) object).getPD_CodigoProducto());
        }
        else {
            return null;
        }
    }
}     