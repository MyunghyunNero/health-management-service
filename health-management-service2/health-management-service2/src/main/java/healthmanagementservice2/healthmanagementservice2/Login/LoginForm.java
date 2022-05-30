package healthmanagementservice2.healthmanagementservice2.Login;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class LoginForm {
    @NotBlank(message = "아이디를 입력해 주세요")
    private String loginId;

    @NotBlank(message = "비밀번호를 입력해 주세요")
    private String password;
}
