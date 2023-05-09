package gechan.core.domain;

import jakarta.persistence.*;

@Entity // @Entity Annotation을 쓰게되면 jpa가 관리하는 entity가 된
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 데이터를 구분하기 위해서 시스템이 저장하는 id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
