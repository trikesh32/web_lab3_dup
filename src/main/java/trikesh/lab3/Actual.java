package trikesh.lab3_dup;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.*;
import trikesh.lab3.utils.AreaChecker;

import java.io.Serializable;

@Getter
@Setter
@Named("actual")
@SessionScoped
public class Actual implements Serializable {
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

    public Actual() {
    }

    public Actual(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public void submit(){
        if (x == null){
            growl.addMessage(FacesMessage.SEVERITY_ERROR, "Select X pls", "Message Content");
        }
        if (y == null){
            growl.addMessage(FacesMessage.SEVERITY_ERROR, "Select Y pls", "Message Content");
        }
        if (r == null){
            growl.addMessage(FacesMessage.SEVERITY_ERROR, "Select R pls", "Message Content");
        }
        if (x != null && y != null && r != null) {
            Boolean isHit = AreaChecker.checkArea(x, y, r);
            resultsList.addResult(new Result(x, y, r, isHit));
        }

    }


}
