package dat;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name ="phone")

public class Phone {

    @Id
    @Column(name ="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "make")
    private String make;
    @OneToOne(mappedBy = "phone")
    private Person person;

    public Phone(String make) {
        this.make = make;
    }

    private int modelYear;

}
