package healthmanagementservice2.healthmanagementservice2.domain.form;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class ItemForm {

    private Long id;
    @NotBlank(message = "이름을 입력하세요")
    private String name;

    private int price;

    private int stockQuantity;
}
