package trikesh.lab3;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import trikesh.lab3.utils.AreaChecker;

import java.io.Serializable;
@Getter
@Setter
@Named("canvasBean")
@ViewScoped
public class CanvasActual implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Double x;
    private Double y;
    private Double r;
    private Boolean isHit;
    @Inject
    @Named("growl")
    private GrowlView growl;

    @Inject
    @Named("resultsList")
    private ResultsList resultsList;

    public void processCoordinate(){
        try {
            this.x = Double.parseDouble(FacesContext.getCurrentInstance()
                    .getExternalContext().getRequestParameterMap().get("x"));
            this.y = Double.parseDouble(FacesContext.getCurrentInstance()
                    .getExternalContext().getRequestParameterMap().get("y"));
            if (r == null){
                growl.addMessage(FacesMessage.SEVERITY_ERROR, "Select R pls", "Message Content");
                return;
            }
        } catch (NumberFormatException e){
            return;
        }
        x /= (100 / r);
        y /= (100 / r);
        Boolean isHit = AreaChecker.checkArea(x, y, r);
        resultsList.addResult(new Result(x, y, r, isHit));
    }
}
