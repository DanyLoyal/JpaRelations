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
@Table(name ="person")

public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    @MapsId
    private Phone phone;

    public Person(String name) {
        this.name = name;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
