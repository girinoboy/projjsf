package br.com.config;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import br.com.tables.EletroFatura;
import br.com.tables.EletroGuia;
import br.com.tables.EletroItemGuia;
import br.com.tables.ErroEletroItemGuia;
import br.com.tables.Event;
import br.com.tables.MockObject;
import br.com.tables.UsuarioDTO;

@SuppressWarnings("deprecation")
public class HibernateUtil {

   // private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory sessionFactory;
    private static final ThreadLocal sessionThread = new ThreadLocal();
    private static final ThreadLocal transactionThread = new ThreadLocal();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static void beginTransaction() {
        Transaction transaction = getSession().beginTransaction();
        transactionThread.set(transaction);
    }
    public static void commitTransaction() {
        Transaction transaction = (Transaction) transactionThread.get();
        if ((transaction != null) && (!(transaction.wasCommitted())) && (!(transaction.wasRolledBack()))) {
            transaction.commit();
            transactionThread.set(null);
        }
    }
    public static void closeSession() {
        Session session = (Session) sessionThread.get();
        if ((session != null) && (session.isOpen())) {
            sessionThread.set(null);
            session.close();
        }
    }
    
    static
    {
        try
        {
            AnnotationConfiguration config = new AnnotationConfiguration();
            //config.setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect");
            //config.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver");
            //config.setProperty("hibernate.connection.url", "jdbc:hsqldb:mem:.demodb");
            //config.setProperty("hibernate.connection.url", "jdbc:hsqldb:file:./data/contratos;shutdown=true");
            //sqlserver
            config.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
            //config.setProperty("hibernate.connection.driver_class","com.microsoft.jdbc.sqlserver.SQLServerDriver");
            config.setProperty("hibernate.connection.driver_class","net.sourceforge.jtds.jdbc.Driver");
            //config.setProperty("hibernate.connection.url", "jdbc:microsoft:sqlserver://10.100.100.132:1433;DatabaseName=citmensageria;SelectMethod=cursor");
            config.setProperty("hibernate.connection.url", "jdbc:jtds:sqlserver://10.100.100.132:1433/citmensageria");
            config.setProperty("hibernate.connection.username", "sa");
            config.setProperty("hibernate.connection.password", "CITmensageria123");
           //config.setProperty("hibernate.default_schema", "prontscm");
            config.setProperty("hibernate.connection.pool_size", "1");
            config.setProperty("hibernate.connection.autocommit", "true");
            config.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.NoCacheProvider");
            config.setProperty("hibernate.hbm2ddl.auto", "update");
            config.setProperty("hibernate.show_sql", "true");
            config.setProperty("hibernate.transaction.factory_class", "org.hibernate.transaction.JDBCTransactionFactory");
            config.setProperty("hibernate.current_session_context_class", "thread");
 
            // Add your mapped classes here:
            //config.addAnnotatedClass(Event.class);
            //config.addAnnotatedClass(MockObject.class);
            //config.addAnnotatedClass(UsuarioDTO.class);
            config.addAnnotatedClass(ErroEletroItemGuia.class);
            config.addAnnotatedClass(EletroItemGuia.class);
            config.addAnnotatedClass(EletroGuia.class);
            config.addAnnotatedClass(EletroFatura.class);
 
            sessionFactory = config.buildSessionFactory();
            
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
    	if(sessionFactory == null)// Create the SessionFactory from hibernate.cfg.xml
    		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        return sessionFactory;
    }
    
    public static Session getSession()
            throws HibernateException {
        return sessionFactory.openSession();
    }
    
    public static void main(String [] args) {
    	beginTransaction();
    	
    	EletroFatura ef = new EletroFatura();
    	
    	ef.setDtEnvioArquivo(new Date());
    	ef.setNumFatura("0000");
    	ef.setVlrPropostoFatura(1d);
    	ef.setNumCnpj('0');
    	getSession().merge(ef);
    	getSession().save(ef);
    	commitTransaction();
    	
    	EletroGuia eg = new EletroGuia();
    	eg.setDtGuia(new Date());
    	eg.setNumMatriculaProser(1);
    	eg.setNumDigitoMatricula(1);
    	eg.setNomeBeneficiario("teste");
    	eg.setEletroFatura(ef);
    	getSession().merge(eg);
    	getSession().save(eg);
    	commitTransaction();
    	
    	EletroItemGuia eig = new EletroItemGuia();
    	
    	eig.setTipoItemAtendimento("teste");
    	eig.setQtdSolicitada(1);
    	eig.setEletroGuia(eg);
    	eig.setVlrUnitarioSolicitado(1d);
    	getSession().merge(eig);
    	getSession().save(eig);
    	commitTransaction();
    	@SuppressWarnings("unchecked")
    	List<EletroItemGuia> liste = getSession().createCriteria(EletroItemGuia.class).list();
    	
    	ErroEletroItemGuia eeig = new ErroEletroItemGuia();
    	eeig.setDescErroEletroItemGuia("R.006");
    	eeig.setEletroItemGuia(eig);
    	
    	getSession().merge(eeig);
    	getSession().save(eeig);
    	commitTransaction();
    	
    	@SuppressWarnings("unchecked")
		List<ErroEletroItemGuia> list = getSession().createCriteria(ErroEletroItemGuia.class).list();
    	
    	 getSession().delete(list.get(0));
         commitTransaction();
         
         getSession().delete(liste.get(0));
         commitTransaction();
         
        closeSession();
        System.exit(0);
    }

}