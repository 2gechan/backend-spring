package gechan.core.controller;

public class MemberForm {
    private String name;

    // createMemberForm.html의 input 태그에서 name="name"이 일치되는 getter, setter를 찾는다
    // getter, setter 기준으로 매핑시켜준다고 함
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
