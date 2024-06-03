package fr.formation.response;

public class EntityCreatedResponse {
    private String id;

    public EntityCreatedResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
