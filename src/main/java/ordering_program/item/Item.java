package ordering_program.item;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //품목 id
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String deadLine;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String unit; //단위(box, g, kg 등...)

    @Column(nullable = false)
    private int baseQuantity; //기본 단위(수량 1, 500, 300...)

    @Column(nullable = false)
    private long price;

    @Column(nullable = false)
    private boolean available; //철마다 품목이 단종되기도 하고 다시 생기기도 하는 경우를 위해 생성


}
