package jpaDaoSingleton;

import dao.DaoTypeBien;
import jakarta.persistence.TypedQuery;
import jpaDto.E_TypeBien;

public class JpaDaoSingletonTypeBien extends JpaDaoSingleton<E_TypeBien> implements DaoTypeBien {

    @Override
    public boolean deleteAll() {
        return super.deleteAll(E_TypeBien.class);
    }

    @Override
    public E_TypeBien findLibTypeBien(String lib) {
        String queryString = "SELECT e FROM E_TypeBien e WHERE e.lib = :lib";
        TypedQuery<E_TypeBien> query = super.entityManager.createQuery(queryString, E_TypeBien.class);
        query.setParameter("lib", lib);
        return query.getSingleResult();
    }

    @Override
    public E_TypeBien find(int id) {
        return super.find(E_TypeBien.class, id);
    }

    private JpaDaoSingletonTypeBien() {
        super();
    }

    private static JpaDaoSingletonTypeBien instance;
    public static JpaDaoSingletonTypeBien getInstance() {
        if (instance == null) {
            instance = new JpaDaoSingletonTypeBien();
        }
        return instance;
    }
}
