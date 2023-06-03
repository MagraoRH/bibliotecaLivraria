package services;

public class ServicosFactory {

    private static ClienteServicos cServicos = new ClienteServicos();
    private static EditoraServicos eServicos = new EditoraServicos();
    private static LivroServicos lServicos = new LivroServicos();

    public static ClienteServicos getClienteServicos() {
        return cServicos;
    }

    public static EditoraServicos getEditoraServicos() {
        return eServicos;
    }

    public static LivroServicos getLivroServicos() {
        return lServicos;
    }
}
