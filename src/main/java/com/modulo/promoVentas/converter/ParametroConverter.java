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
import com.modulo.promoVentas.model.Parametro;
import com.modulo.promoVentas.service.ParametroServiceImpl;
import com.modulo.promoVentas.service.ParametroService;

@FacesConverter("parametroConverter")
public class ParametroConverter implements Converter{
	
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                ApplicationContext ctx = WebApplicationContextUtils
                        .getRequiredWebApplicationContext((ServletContext) FacesContext
                                .getCurrentInstance().getExternalContext()
                                .getContext());
            	ParametroService service = (ParametroServiceImpl) ctx.getBean("parametroServiceImpl");
                return service.getParametro(Integer.parseInt(value));   
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
            return String.valueOf(((Parametro) object).getPD_CodigoParametroDet());
        }
        else {
            return null;
        }
    }
}     