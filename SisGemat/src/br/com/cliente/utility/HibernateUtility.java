package br.com.cliente.utility;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.cliente.models.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

@SuppressWarnings("unchecked")
public class HibernateUtility {

    private static SessionFactory factory;
    @SuppressWarnings("rawtypes")
	private static final ThreadLocal sessionThread = new ThreadLocal();
    @SuppressWarnings("rawtypes")
	private static final ThreadLocal transactionThread = new ThreadLocal();

    
	public static Session getSession() {
        Session session = (Session) sessionThread.get();
        if ((session == null) || (!(session.isOpen()))) {
            session = factory.openSession();
            sessionThread.set(session);
        }
        return ((Session) sessionThread.get());
    }

    public static void closeSession() {
        Session session = (Session) sessionThread.get();
        if ((session != null) && (session.isOpen())) {
            sessionThread.set(null);
            session.close();
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

    public static void rollbackTransaction() {
        Transaction transaction = (Transaction) transactionThread.get();
        if ((transaction != null) && (!(transaction.wasCommitted())) && (!(transaction.wasRolledBack()))) {
            transaction.rollback();
            transactionThread.set(null);
        }
    }

    static {
        try {
            factory = new Configuration()
//                    //HSQLDB/
                    .setProperty("hibernate.dialect", "org.hibernate.dialect.HSQLDialect") // tipo de dialeto do banco
                    //.setProperty("hibernate.connection.driver_class", "org.hsqldb.jdbcDriver") // driver do banco
                   // .setProperty("hibernate.connection.url", "jdbc:hsqldb:file:./data/cliente;shutdown=true") // endereço do banco de dados
                    //.setProperty("hibernate.connection.username", "sa")
                    //.setProperty("hibernate.connection.password", "")
                    .setProperty("hibernate.connection.datasource", "java:DefaultDS")
                    .setProperty("hibernate.hbm2ddl.auto", "update")
                    .setProperty("hibernate.c3p0.max_size", "10")
                    .setProperty("hibernate.c3p0.min_size", "2")
                    .setProperty("hibernate.c3p0.timeout", "5000")
                    .setProperty("hibernate.c3p0.max_statements", "10")
                    .setProperty("hibernate.c3p0.idle_test_period", "3000")
                    .setProperty("hibernate.c3p0.acquire_increment", "2")
                    .setProperty("show_sql", "true")
                    .setProperty("use_outer_join", "true")
                    .setProperty("hibernate.generate_statistics", "true")
                    .setProperty("hibernate.use_sql_comments", "true")
                    .setProperty("hibernate.format_sql", "true")
                    //CADASTROS abaixo coloque todas classes que deseja ser modelo para criação do banco de dados
                    .addAnnotatedClass(Cliente.class)
                    //MOVIMENTOS
                    .buildSessionFactory();
            
            //factory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();  
                   
            
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String [] args) {

    }

}

