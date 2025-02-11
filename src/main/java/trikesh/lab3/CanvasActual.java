package trikesh.lab3;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@Named("canvasBean")
@ViewScoped
public class CanvasActual implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Double x;
    private Double y;
    private Double
}
