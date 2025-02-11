package trikesh.lab3_dup.convertors;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;

@FacesConverter("xConverter")
public class XConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return Double.parseDouble(value.trim());
        } catch (NumberFormatException e) {
            FacesMessage msg = new FacesMessage("Select X");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(msg);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null) {
            return "";  // Если значение null, возвращаем пустую строку
        }
        return value.toString();
    }
}
