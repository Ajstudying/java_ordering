package ordering_program.item;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ItemListResponse {
    private List<Item> itemList;
}
