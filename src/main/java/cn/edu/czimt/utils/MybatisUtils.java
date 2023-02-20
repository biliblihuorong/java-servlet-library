package cn.edu.czimt.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MybatisUtils {
    private static SqlSessionFactory sessionFactory;
    private static final ThreadLocal<SqlSession> local = new ThreadLocal<>();
    static {
        InputStream inputStream = null;
        try {
            inputStream= Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            sessionFactory=sqlSessionFactoryBuilder.build(inputStream);
        }catch (Exception e){

        }
    }
    private static SqlSession getSqlSession (Boolean b){
        SqlSession session = local.get();
        if (session ==null){
            session= sessionFactory.openSession();
            local.set(session);
        }
        return session;
    }
    public static SqlSession getSqlSession (){
        return getSqlSession(false);
    }
    public static  <T extends Object >T getMapper(Class<T> t){
        SqlSession session = sessionFactory.openSession();
        return session.getMapper(t);
    }
}
