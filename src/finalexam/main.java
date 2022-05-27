package finalexam;

public class main {

    public static void main(String[] args) {
        MovieView view = new MovieView();
        Connector connector = new Connector();
        Controller controller = new Controller(connector, view);
    }
}
