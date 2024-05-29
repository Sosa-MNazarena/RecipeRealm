package Modelos;

import java.util.ArrayList;
import java.util.List;

public class RecetaSingleton {
    private static RecetaSingleton instance;
    private List<Receta> recetas;

    private RecetaSingleton() {
        recetas = new ArrayList<>();
    }

    public static RecetaSingleton getInstance() {
        if (instance == null) {
            instance = new RecetaSingleton();
        }
        return instance;
    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void addReceta(Receta receta) {
        recetas.add(receta);
    }

    public void removeReceta(Receta receta) {
        recetas.remove(receta);
    }
}
