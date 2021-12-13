package com.bilgeadam.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.bilgeadam.entity.StudentEntity;
import com.bilgeadam.hibernateconfig.IDatabaseCrud;

public class StudentController implements Serializable, IDatabaseCrud<StudentEntity> {
	
	private static final long serialVersionUID = -1213775719782464391L;
	private static final Logger logger = LogManager.getLogger(StudentController.class); // logger classı import
	// all < trace=yeşil < debug=yeşil < info=yeşil < warn=sarı < error=kırmızı <
	// fatal=kırmız < off
	
	public static void main(String[] args) {
		logger.trace("trace logger durumu");
		logger.debug("debug logger durumu");
		logger.info("info logger durumu");
		logger.warn("warn logger durumu");
		logger.error("error logger durumu");
		logger.fatal("fatal logger durumu");
	}
	
	// DML:Create Delete Update : transaction
	// DQL:select : transaction isteğe bağlı
	// create:persist
	// delete: remove
	// update: merge
	// find : find
	
	// Ekleme
	@Override
	public void create(StudentEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamdır" + StudentController.class);
		} catch (Exception e) {
			logger.error("ekleme anında hata meydana geldi !!!!! " + StudentController.class);
			e.printStackTrace();
		}
	}
	
	// silmek
	@Override
	public void delete(StudentEntity entity) {
		
		try {
			StudentEntity findEntity = find(entity.getStudentId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				logger.info("Silme Başarılı " + StudentEntity.class);
			}
		} catch (Exception e) {
			logger.error("silme anında hata meydana geldi !!!!! " + StudentController.class);
			e.printStackTrace();
		}
		
	}
	
	// güncellemek
	@Override
	public void update(StudentEntity entity) {
		try {
			StudentEntity findEntity = find(entity.getStudentId());
			if (findEntity != null) {
				findEntity.setEmailAddress(entity.getEmailAddress());
				findEntity.setStudentName(entity.getStudentName());
				findEntity.setStudentPassword(entity.getStudentPassword());
				findEntity.setStudentSurname(entity.getStudentSurname());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				logger.info("Güncelleme Başarılı " + StudentEntity.class);
			}
			
		} catch (Exception e) {
			logger.error("güncelleme anında hata meydana geldi !!!!! " + StudentController.class);
			e.printStackTrace();
		}
	}
	
	// listelemek
	@Override
	public ArrayList<StudentEntity> list() {
		Session session = databaseConnectionHibernate();
		
		// unutma: buradaki sorgulama entity sorgulaması yani java classına göre
		// çağıracağız.
		String hql = "select str from StudentEntity as str where str.id>=:key";
		TypedQuery<StudentEntity> typedQuery = session.createQuery(hql, StudentEntity.class);
		
		long id = 1L;
		typedQuery.setParameter("key", id);
		
		ArrayList<StudentEntity> arrayList = (ArrayList<StudentEntity>) typedQuery.getResultList();
		logger.info("listelendi " + StudentEntity.class);
		return arrayList;
	}
	
	// find
	@Override
	public StudentEntity find(long id) {
		Session session = databaseConnectionHibernate();
		StudentEntity studentEntity;
		try {
			studentEntity = session.find(StudentEntity.class, id);
			
			if (studentEntity != null) {
				System.out.println("bulundu... " + studentEntity);
				return studentEntity;
			} else {
				System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
				return null;
			}
		} catch (Exception e) {
			logger.error("find anında hata meydana geldi !!!!! " + StudentController.class);
			e.printStackTrace();
		}
		return null;
	}
	
	// tek kayıt donder
	@Override
	public StudentEntity singleResult(long id) {
		// TODO Auto-generated method stub
		return IDatabaseCrud.super.singleResult(id);
	}
	
}
