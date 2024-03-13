package BR.Service;

import BR.DAO.IContratoDao;


public class ContratoService implements IContratoService {

    private IContratoDao contratoDao;

    public ContratoService(IContratoDao dao) {
        this.contratoDao = dao;
    }

    @Override
    public String salvar() {
        contratoDao.salvar();
        return "Sucesso";
    }

    @Override
    public String excluir() {
        contratoDao.excluir();
        return "Excluido";
    }

    @Override
    public String busca() {
        contratoDao.busca();
     return "Buscando";
    }

    @Override
    public String atualizar() {
        contratoDao.atualizar();
       return "Atualizado";
    }

    @Override
    public String retornar(String string) {
        contratoDao.retornar(string);
        return string;
    }
}
