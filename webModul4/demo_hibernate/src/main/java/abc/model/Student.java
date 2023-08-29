package abc.model;

import javax.persistence.*;

@Entity
public class Student {
    @Id // khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id tự động tăng dần
    private int id;

    @Column(columnDefinition = "varchar(255) default 'bang'") // mặc định k điền giá trị thì sẽ bằng " Bang". giống deful trong sql
    private String name;

    private String img;

    @ManyToOne
    private ClassRoom classRoom;

    public Student() {
    }

    public Student(int id, String name, String img, ClassRoom classRoom) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.classRoom = classRoom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }
}
