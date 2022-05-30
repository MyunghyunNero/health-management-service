package healthmanagementservice2.healthmanagementservice2.domain;

import lombok.Data;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class SignMember {
    @NotBlank(message = "아이디를 입력하세요")
    private String loginId;

    @NotBlank(message = "이름을 입력하세요")
    private String name;

    @NotBlank(message = "비밀번호를 입력하세요")
    private String password;
}
