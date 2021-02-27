package br.edu.ifrn.pi.bookcrud.model.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifrn.pi.bookcrud.model.entity.TradeAgreement;
    
@FacesConverter(forClass = TradeAgreement.class)
public class TradeAgreementConverter implements Converter {
    @Override
    public TradeAgreement getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (TradeAgreement) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof TradeAgreement) {
        	TradeAgreement entity= (TradeAgreement) value;
            if (entity != null && entity instanceof TradeAgreement && entity.getId() != null) {
                uiComponent.getAttributes().put( entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }
        return "";
    }
}