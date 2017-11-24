import controller.Controller;
import model.Model;
import model.entities.Note;
import view.View;
import view.utility.key_words.KeyWords;
import view.utility.Localization;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static KeyWords keyWords;
    private static List<Note> notes = new ArrayList<Note>();

    public static void main(String[] args) {
        Localization localization = Localization.INSTANCE;
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(view,model,notes);
        controller.work();
    }
}
