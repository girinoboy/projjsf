package br.com.cliente.daos;

import br.com.cliente.models.Cliente;
import br.com.cliente.utility.DaoGenericoImpl;
import br.com.cliente.utility.HibernateUtility;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;

//@author M.N.M
public class ClienteDaoImpl extends DaoGenericoImpl < Cliente , Long > implements ClienteDao {

    @Override
    public List consultar() {
        List lista = new ArrayList();
        Criteria crit = HibernateUtility.getSession().createCriteria(Cliente.class);

        lista = (List) crit.list();
        return lista;
    }
}

