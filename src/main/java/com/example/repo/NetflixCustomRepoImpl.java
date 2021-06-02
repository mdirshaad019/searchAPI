package com.example.repo;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.dto.NetflixData;
import com.example.models.Netflix;

@Repository
public class NetflixCustomRepoImpl implements NetflixCustomRepo{
	
	EntityManager entityManager;
	
	final static String AND_APPEND = "AND";
	final static String WHERE_APPEND = "WHERE";
	
	public NetflixCustomRepoImpl(EntityManager e) {
		entityManager =e;
	}

	@Override
	public List<Object[]> getAll(NetflixData netflixData,int pageNo) {
		String queryBuilder = "select * from netflix n ";
		String postfix = "";
		
		if(Objects.nonNull(netflixData.getDirector())){
			queryBuilder += "JOIN Director d on d.id=n.director ";
			postfix += " d.director = '" + netflixData.getDirector()+"'";
		}
		if(Objects.nonNull(netflixData.getCast())){
			queryBuilder += "JOIN Cast c on c.id=n.cast ";
			if(postfix != "")
				postfix += AND_APPEND;
			postfix += " c.cast = '" + netflixData.getCast()+"'";
		}
		if(Objects.nonNull(netflixData.getCountry())){
			queryBuilder += "JOIN Country cn on cn.id=n.director ";
			if(postfix != "")
				postfix += AND_APPEND;
			postfix += " cn.country = '" + netflixData.getCountry()+"'";
		}
		
		if(Objects.nonNull(netflixData.getListed_in())){
			queryBuilder += "JOIN ListedIn l on l.id=n.director ";
			if(postfix != "")
				postfix += AND_APPEND;
			postfix += " n.listed_in = '" + netflixData.getListed_in()+"'";
		}
		if(Objects.nonNull(netflixData.getType())) {
			if(postfix != "")
				postfix += AND_APPEND;
			postfix += " n.type = '" + netflixData.getType()+"'";
		}
		if(Objects.nonNull(netflixData.getTitle())) {
			if(postfix != "")
				postfix += AND_APPEND;
			postfix += " n.title = '" + netflixData.getTitle()+"'";
		}
		if(Objects.nonNull(netflixData.getDate())) {
			if(postfix != "")
				postfix += AND_APPEND;
			postfix += " n.date = '" + netflixData.getDate()+"'";
		}
		if(Objects.nonNull(netflixData.getYear())) {
			if(postfix != "")
				postfix += AND_APPEND;
			postfix += " n.year = '" + netflixData.getYear()+"'";
		}
		if(Objects.nonNull(netflixData.getRating())) {
			if(postfix != "")
				postfix += AND_APPEND;
			postfix += " n.rating = '" + netflixData.getRating()+"'";
		}
		if(Objects.nonNull(netflixData.getDuration()) && netflixData.getDuration()>0) {
			if(postfix != "")
				postfix += AND_APPEND;
			postfix += " n.duration = '" + netflixData.getDuration()+"'";
		}
		if(Objects.nonNull(netflixData.getDurationType())) {
			if(postfix != "")
				postfix += AND_APPEND;
			postfix += " durationType = '" + netflixData.getDurationType()+"'";
		}
		if(postfix != "")
			postfix += AND_APPEND;
		postfix += " n.show_id = '" + netflixData.getShowId() +"'"; 
		queryBuilder = queryBuilder + WHERE_APPEND + postfix;
		
		Query query = entityManager.createNativeQuery(queryBuilder);
		int pageNumber = pageNo;
		int pageSize = 10;
		query.setFirstResult((pageNumber-1) * pageSize); 
		query.setMaxResults(pageSize);
		return query.getResultList().size() == 0 ? null : query.getResultList() ;
	}

}
