import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class TechStack {
    private String name;
    private String version;
    private List<String> dependencies;
    private List<String> configFiles;

    // Constructor
    public TechStack(String name, String version, List<String> dependencies, List<String> configFiles) {
        this.name = name;
        this.version = version;
        this.dependencies = dependencies;
        this.configFiles = configFiles;
    }

    // Getters and setters
    public String getName() { return name; }
    public String getVersion() { return version; }
    public List<String> getDependencies() { return dependencies; }
    public List<String> getConfigFiles() { return configFiles; }

    // Método para cargar las tecnologías desde un archivo JSON
    public static List<TechStack> loadTechStacks(String filePath) {
        List<TechStack> techStacks = new ArrayList<>();
        try {
            // Leer el archivo JSON como un String
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Parsear el contenido JSON
            JSONArray jsonArray = new JSONArray(content);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                String name = jsonObject.getString("name");
                String version = jsonObject.getString("version");

                // Convertir dependencias y archivos de configuración a listas
                List<String> dependencies = new ArrayList<>();
                JSONArray dependenciesArray = jsonObject.getJSONArray("dependencies");
                for (int j = 0; j < dependenciesArray.length(); j++) {
                    dependencies.add(dependenciesArray.getString(j));
                }

                List<String> configFiles = new ArrayList<>();
                JSONArray configFilesArray = jsonObject.getJSONArray("configFiles");
                for (int j = 0; j < configFilesArray.length(); j++) {
                    configFiles.add(configFilesArray.getString(j));
                }

                // Crear una instancia de TechStack y agregarla a la lista
                techStacks.add(new TechStack(name, version, dependencies, configFiles));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return techStacks;
    }
}
