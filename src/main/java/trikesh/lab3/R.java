package trikesh.lab3;


import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

@Named("r")
@ViewScoped
@Getter
@Setter
public class R implements Serializable {
    private Boolean checkBox1 = false;
    private Boolean checkBox2 = false;
    private Boolean checkBox3 = false;
    private Boolean checkBox4 = false;
    private Boolean checkBox5 = false;

    @Inject
    @Named("actual")
    private Actual actualBean;
    @Inject
    @Named("canvasBean")
    private CanvasActual canvasBean;

    public R() {
    }

    public void checkBox1Clicked() {
        checkBox2 = false;
        checkBox3 = false;
        checkBox4 = false;
        checkBox5 = false;
        if (checkBox1) {
            actualBean.setR(1.0);
            canvasBean.setR(1.0);
        } else {
            actualBean.setR(null);
            canvasBean.setR(null);
        }
    }

    public void checkBox2Clicked() {
        checkBox1 = false;
        checkBox3 = false;
        checkBox4 = false;
        checkBox5 = false;
        if (checkBox2) {
            actualBean.setR(2.0);
            canvasBean.setR(2.0);
        } else {
            actualBean.setR(null);
            canvasBean.setR(null);
        }
    }

    public void checkBox3Clicked() {
        checkBox2 = false;
        checkBox1 = false;
        checkBox4 = false;
        checkBox5 = false;
        if (checkBox3) {
            actualBean.setR(3.0);
            canvasBean.setR(3.0);
        } else {
            actualBean.setR(null);
            canvasBean.setR(null);
        }
    }

    public void checkBox4Clicked() {
        checkBox2 = false;
        checkBox3 = false;
        checkBox1 = false;
        checkBox5 = false;
        if (checkBox4) {
            actualBean.setR(4.0);
            canvasBean.setR(4.0);
        } else {
            actualBean.setR(null);
            canvasBean.setR(null);
        }
    }

    public void checkBox5Clicked() {
        checkBox2 = false;
        checkBox3 = false;
        checkBox1 = false;
        checkBox4 = false;
        if (checkBox5) {
            actualBean.setR(5.0);
            canvasBean.setR(5.0);
        } else {
            actualBean.setR(null);
            canvasBean.setR(null);
        }
    }
}
