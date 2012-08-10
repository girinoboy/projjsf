package br.com.cliente.daos;

import br.com.cliente.models.Cliente;
import br.com.cliente.utility.DaoGenerico;
import java.util.List;

//@author M.N.M
public interface ClienteDao extends DaoGenerico <Cliente, Long> {

    public List<Cliente> consultar();
}


