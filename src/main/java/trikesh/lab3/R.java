package trikesh.lab3_dup;


import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Arrays;

@Named("r")
@SessionScoped
public class R implements Serializable {
    @Setter
    @Getter
    private boolean[] checkboxes = new boolean[5];

    @Getter
    @Setter
    @Inject
    @Named("actual")
    private Actual actualBean;

    public R() {
        Arrays.fill(checkboxes, false);
    }

    public R(boolean[] checkboxes) {
        this.checkboxes = checkboxes;
    }

    public void selectCheckbox(int index) {
        if (!checkboxes[index]) {
            Arrays.fill(checkboxes, false);
            checkboxes[index] = true;
            actualBean.setR(null);

        } else {
            Arrays.fill(checkboxes, false);
            actualBean.setR((double) (index + 1));
        }
    }

    public boolean getCheckbox(int i) {
        return checkboxes[i];
    }
}
