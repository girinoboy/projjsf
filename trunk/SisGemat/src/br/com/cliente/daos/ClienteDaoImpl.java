package br.com.cliente.daos;

import br.com.cliente.models.Cliente;
import br.com.cliente.utility.DaoGenericoImpl;
import br.com.cliente.utility.HibernateUtility;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;

//@author M.N.M
public class ClienteDaoImpl extends DaoGenericoImpl < Cliente , Long > implements ClienteDao {

    @SuppressWarnings("unchecked")
	@Override
    public List<Cliente> consultar() {
        List<Cliente> lista = new ArrayList<Cliente>();
        Criteria crit = HibernateUtility.getSession().createCriteria(Cliente.class);

        lista = (List<Cliente>) crit.list();
        return lista;
    }
}

