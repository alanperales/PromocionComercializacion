package com.modulo.promoVentas.converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import com.modulo.promoVentas.model.Parametro;
import com.modulo.promoVentas.utils.Constantes;

@FacesConverter("parametroTipoConverter")
public class ParametroTipoConverter implements Converter{

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
            	Parametro parametro = new Parametro();
        		parametro.setPD_CodigoParametroDet(Integer.parseInt(value));
            	if(Integer.parseInt(value)==Constantes.PROMO_POR_CADA){
            		parametro.setPD_NombreElemento("Cantidad ofrecida");
            		return parametro;
            	}else 
                	if(Integer.parseInt(value)==Constantes.PROMO_REBAJA_PRECIO){
                		parametro.setPD_NombreElemento("Bajar precio");
                		return parametro;
                	}else 
                    	if(Integer.parseInt(value)==Constantes.PROMO_DESCUENTO_FIJO){
                    		parametro.setPD_NombreElemento("Descuento");
                    		return parametro;
                    	}else 
                        	if(Integer.parseInt(value)==Constantes.PROMO_DESCUENTO_FIJO_POR_MAYOR){
                        		parametro.setPD_NombreElemento("Precio mayor a");
                        		return parametro;
                        	}else return null;
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