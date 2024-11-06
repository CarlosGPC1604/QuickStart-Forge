import java.util.List;

public class ProjectGenerator {
    private PathManager pathManager;
    private List<TechStack> techStacks;

    public ProjectGenerator(PathManager pathManager, List<TechStack> techStacks) {
        this.pathManager = pathManager;
        this.techStacks = techStacks;
    }

    public void generate(String projectPath) {
        pathManager.createProjectStructure(projectPath, techStacks);
        // Puedes agregar aquí lógica adicional para manejar configuraciones específicas de cada stack
    }
}