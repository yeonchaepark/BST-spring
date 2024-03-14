package BST.BSTspring.Service;

import BST.BSTspring.controller.MemberDTO;

import java.util.Map;

public class MemberService {
    public void updateAuthStatus(Map<String, String> map) {
        // 이메일 인증 상태를 업데이트하는 로직을 작성합니다.
        String email = map.get("email");
        String status = map.get("status");
        // email과 status를 사용하여 데이터베이스나 다른 저장소에서 해당 멤버의 인증 상태를 업데이트합니다.
    }

    public void updateAuthKey(Map<String, String> map) {
        // 인증 키를 업데이트하는 로직을 작성합니다.
        String email = map.get("email");
        String authKey = map.get("authKey");
        // email과 authKey를 사용하여 데이터베이스나 다른 저장소에서 해당 멤버의 인증 키를 업데이트합니다.
    }

    public void signUp(MemberDTO memberDTO) {
        // 회원가입 로직을 작성합니다.
        // 회원가입에 필요한 정보는 MemberDTO에 포함되어 있습니다.
        // 예를 들어, memberDTO.getEmail(), memberDTO.getAuthKey() 등을 사용하여 회원 정보를 저장합니다.
    }
}

