import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<TechStack> techStacks = TechStack.loadTechStacks("tech_stack.json");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido a QuickStart Forge");
        System.out.print("Ingrese la ruta de su proyecto: ");
        String projectPath = scanner.nextLine();

        System.out.println("Seleccione las tecnologías que desea usar (ingrese el número correspondiente):");
        for (int i = 0; i < techStacks.size(); i++) {
            System.out.println((i + 1) + ". " + techStacks.get(i).getName());
        }

        // Seleccionar tecnologías
        List<TechStack> selectedTechs = new ArrayList<>();
        while (true) {
            System.out.print("Ingrese el número de tecnología (o 0 para finalizar): ");
            int choice = scanner.nextInt();
            if (choice == 0) break;
            if (choice > 0 && choice <= techStacks.size()) {
                selectedTechs.add(techStacks.get(choice - 1));
            } else {
                System.out.println("Selección inválida. Intente de nuevo.");
            }
        }

        ProjectGenerator generator = new ProjectGenerator(new PathManager(), selectedTechs);
        generator.generate(projectPath);

        System.out.println("Proyecto generado exitosamente en: " + projectPath);
        scanner.close();
    }
}
