package pl.prozprojekt.testingsystem.mappers;

public interface Mapper<Entity, View> {
    public View convertToView(Entity entity);

    public Entity convertToEntity(View view);
}
