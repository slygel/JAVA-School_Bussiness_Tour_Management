package models;

import java.util.List;
import java.util.Objects;

public class Classroom {

    public static int count = 0;

    private int id;
    private String code;
    private String name;
    private List<Student> students;

    public Classroom(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }
    
    public Classroom(String code, String name) {
        this.code = code;
        this.name = name;
    }
    

    public Classroom() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString(){
        return name;
    }
    public String toStringFile() {
        return id + "," + code + "," + name + "," + students;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Classroom other = (Classroom) obj;
        return Objects.equals(id, other.id);
    }

}
