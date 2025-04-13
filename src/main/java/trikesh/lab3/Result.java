package trikesh.lab3;

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
    public Result(Double x, Double y, Double r, Boolean isHit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.isHit = isHit;
    }

    public Result() {

    }
    @Id
    @GeneratedValue
    @Column(name="id", unique = true)
    private Long id;

    @Column(name = "x", nullable = false)
    private Double x;

    @Column(name = "y", nullable = false)
    private Double y;

    @Column(name = "r", nullable = false)
    private Double r;

    @Column(name = "result")
    private Boolean isHit;


}
