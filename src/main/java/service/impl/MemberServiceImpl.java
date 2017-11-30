package service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import dao.MemberDao;
import entity.Member;
import service.MemberService;

@Service("MemberServiceImpl")
public class MemberServiceImpl implements MemberService{
	
	@Resource(name="MemberDaoImpl")
	MemberDao memberDao;

	@Override
	public boolean save(Member member) {
		if(1==memberDao.save(member)){
			return true;
		}
		return false;
	}
}
