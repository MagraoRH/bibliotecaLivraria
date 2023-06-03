package dao;

public class DAOFactory {

    private static ClienteDAO cDAO = new ClienteDAO();
    private static EditoraDAO eDAO = new EditoraDAO();
    private static LivroDAO lDAO = new LivroDAO();

    public static ClienteDAO getClienteDAO() {
        return cDAO;
    }

    public static EditoraDAO getEditoraDAO() {
        return eDAO;
    }

    public static LivroDAO getLivroDAO() {
        return lDAO;
    }
}
