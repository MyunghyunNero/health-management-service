package healthmanagementservice2.healthmanagementservice2.domain;

import lombok.Data;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;

import javax.validation.constraints.NotEmpty;

@Data
public class SignMember {
    @NotEmpty
    private String loginId;

    @NotEmpty
    private String name;

    @NotEmpty
    private String password;
}
