package com.modulo.promoVentas.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.servlet.ServletContext;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.modulo.promoVentas.model.Persona;
import com.modulo.promoVentas.service.ClienteService;
import com.modulo.promoVentas.service.ClienteServiceImpl;

@FacesConverter("clienteConverter")
public class ClienteConverter implements Converter{
	
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                ApplicationContext ctx = WebApplicationContextUtils
                        .getRequiredWebApplicationContext((ServletContext) FacesContext
                                .getCurrentInstance().getExternalContext()
                                .getContext());
            	ClienteService service = (ClienteServiceImpl) ctx.getBean("clienteServiceImpl");
                return service.getCliente(Integer.parseInt(value));   
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
            return String.valueOf(((Persona) object).getPE_CodigoPersona());
        }
        else {
            return null;
        }
    }
}     