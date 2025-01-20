package ordering_program.order;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderRequest {
    private String title;
    private String company;
    private String unit;
    private int quantity;
    private long price;
    private String createTime;
}
