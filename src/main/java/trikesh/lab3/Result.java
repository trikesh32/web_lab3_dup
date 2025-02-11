package trikesh.lab3_dup;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "result")
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "x", nullable = false)
    private Double x;

    @Column(name = "y", nullable = false)
    private Double y;

    @Column(name = "r", nullable = false)
    private Double r;

    @Column(name = "result", nullable = false)
    private Boolean isHit;

    public Result(Double x, Double y, Double r, Boolean isHit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.isHit = isHit;
    }

    public Result() {

    }
}
