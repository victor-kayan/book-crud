package br.edu.ifrn.pi.bookcrud.model.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.ifrn.pi.bookcrud.model.entity.Book;
    
@FacesConverter(forClass = Book.class)
public class BookConverter implements Converter {
    @Override
    public Book getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        if (value != null && !value.isEmpty()) {
            return (Book) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value instanceof Book) {
        	Book entity= (Book) value;
            if (entity != null && entity instanceof Book && entity.getId() != null) {
                uiComponent.getAttributes().put( entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }
        return "";
    }
}