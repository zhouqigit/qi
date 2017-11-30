package dao.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import dao.MemberDao;
import entity.Member;

@Repository("MemberDaoImpl")
public class MemberDaoImpl implements MemberDao {
	
	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	@Override
	public Integer save(Member member) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Serializable flag=session.save(member);
		session.getTransaction().commit();
		session.close();
		System.out.println(flag);
		return 1;
	}

}
