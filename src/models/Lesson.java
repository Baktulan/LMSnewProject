package models;

public class Lesson {
    private Long id;
    private String name;
    private String description;

    public Lesson(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nLESSON:").append("\n")
                .append("ID: ").append(id).append("\n")
                .append("NAME: ").append(name).append("\n")
                .append("DESCRIPTION: ").append(description).append("\n")
                .append("~~~~~~~~~~~~~~~~~~~");
        return sb.toString();

    }
}
