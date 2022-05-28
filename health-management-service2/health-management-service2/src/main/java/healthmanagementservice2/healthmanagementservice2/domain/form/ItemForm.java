package healthmanagementservice2.healthmanagementservice2.domain.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class ItemForm {

    private Long id;
    @NotEmpty
    private String name;

    private int price;

    private int stockQuantity;
}
