package ordering_program.order;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "orders") // 데이터베이스 테이블 이름
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //품목 id
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String company;

    @Column(nullable = false)
    private String unit; //단위(box, g, kg 등...)

    @Column(nullable = false)
    private int quantity; //수량

    @Column(nullable = false)
    private long price;

    //d-3 상품 등이 마감됐을 때 사용할 변수
    private boolean orderAvailableData;

    //발주 생성 날짜
    @Column(nullable = false)
    private LocalDate createdTime;

    // 발주 마감 시간을 오후 5시로 고정된 상수로 정의
    public static final LocalTime ORDER_DEADLINE = LocalTime.of(17, 0); // 17:00
}
