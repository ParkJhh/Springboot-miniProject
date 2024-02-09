package com.kitri.mytodo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberInfo {
    Long memberid;

    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
    String email;

    @NonNull
    String name;

    @NotEmpty(message = "비밀번호 입력은 필수 입니다.")
    @Size(min = 8, message = "비밀번호는 최소 8자 이상,20자미만 합니다.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[!@#$%^&*?_]).{8,19}$")
    String password;

    String passwordChk;

    public MemberInfo(String email, @NonNull String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public MemberInfo(Long memberid, String email, @NonNull String name, String password) {
        this.memberid = memberid;
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
