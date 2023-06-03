package services;

import Model.Livro;
import dao.LivroDAO;
import dao.DAOFactory;
import java.util.ArrayList;

public class LivroServicos {

    public void cadLivro(Livro lVO) {
        LivroDAO eDAO = DAOFactory.getLivroDAO();
        eDAO.cadastrarLivroDAO(lVO);
    }

    public void atualizarLivro(Livro lVO) {
        LivroDAO eDAO = DAOFactory.getLivroDAO();
        eDAO.atualizarLivroByDoo(lVO);
    }

    public void deletarLivro(String cnpj) {
        LivroDAO eDAO = DAOFactory.getLivroDAO();
        eDAO.deletarLivroDAO(cnpj);
    }

    public Livro buscarLivrobyCNPJ(String cnpj) {
        LivroDAO eDAO = DAOFactory.getLivroDAO();
        return eDAO.getLivroByDoc(cnpj);
    }

    public ArrayList<Livro> getLivros() {
        LivroDAO eDAO = DAOFactory.getLivroDAO();
        return eDAO.getLivrosDAO();
    }
}
