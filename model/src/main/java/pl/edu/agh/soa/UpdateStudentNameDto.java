package pl.edu.agh.soa;

public class UpdateStudentNameDto {
    public Integer id;
    public String new_name;

    public UpdateStudentNameDto() {
    }

    public UpdateStudentNameDto(Integer id, String new_name) {
        this.id = id;
        this.new_name = new_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNew_name() {
        return new_name;
    }

    public void setNew_name(String new_name) {
        this.new_name = new_name;
    }
}
