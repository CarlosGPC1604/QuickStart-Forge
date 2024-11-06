import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PathManager {
    public void createProjectStructure(String basePath, List<TechStack> selectedTechStacks) {
        try {
            Path base = Paths.get(basePath);
            if (Files.notExists(base)) {
                Files.createDirectories(base);
            }

            // Crear carpetas y archivos específicos para cada stack
            for (TechStack tech : selectedTechStacks) {
                Path techPath = base.resolve(tech.getName());
                Files.createDirectories(techPath);

                // Crear archivos de configuración definidos en cada TechStack
                for (String configFile : tech.getConfigFiles()) {
                    Path configFilePath = techPath.resolve(configFile);
                    Files.createFile(configFilePath);
                }
            }

            System.out.println("Estructura de proyecto creada en: " + basePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}