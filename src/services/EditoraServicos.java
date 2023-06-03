package services;

import Model.Editora;
import dao.EditoraDAO;
import dao.DAOFactory;
import java.util.ArrayList;

public class EditoraServicos {

    public void cadEditora(Editora eVO) {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        eDAO.cadastrarEditoraDAO(eVO);
    }

    public void atualizarEditora(Editora eVO) {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        eDAO.atualizarEditoraByDoo(eVO);
    }

    public void deletarEditora(String cnpj) {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        eDAO.deletarEditoraDAO(cnpj);
    }

    public Editora buscarEditorabyCNPJ(String cnpj) {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        return eDAO.getEditoraByDoc(cnpj);
    }

    public ArrayList<Editora> getEditoras() {
        EditoraDAO eDAO = DAOFactory.getEditoraDAO();
        return eDAO.getEditorasDAO();
    }
}
