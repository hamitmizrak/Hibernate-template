package com.bilgeadam.main;

import com.bilgeadam.controller.StudentController;
import com.bilgeadam.entity.StudentEntity;

public class StudentEntityMain {
	
	public static void main(String[] args) {
		// JPQL
		// HQL
		
		//// Create
		// String bigData, String studentName, String studentSurname, String
		//// emailAddress,
		// String studentPassword, int tcNumber
		for (int i = 0; i < 10; i++) {
			StudentEntity studentEntity = new StudentEntity("big data " + i, "Hamit " + i, "Mızrak" + i,
					"hamitmizrak@gmail.com " + i, "passwords" + i, 100 + i);
			StudentController studentController1 = new StudentController();
			studentController1.create(studentEntity);
		}
		// StudentEntity studentEntity = new StudentEntity("Hamit", "Mızrak",
		// "hamitmizrak@gmail.com", "455155");
		// StudentController studentController1 = new StudentController();
		// studentController1.create(studentEntity);
		
		//// find
		// StudentController studentController2 = new StudentController();
		// long id = 1;
		// studentController2.find(id);
		
		// // delete
		// StudentController studentController3 = new StudentController();
		// StudentEntity studentEntity2 = new StudentEntity();
		// studentEntity2.setStudentId(2L);
		// studentController3.delete(studentEntity2);
		
		// // update
		// StudentEntity studentEntity4 = new StudentEntity("Melih", "Dumanlı",
		// "d.dumanli@gmail.com", "111111");
		// studentEntity4.setStudentId(1);
		// StudentController studentController4 = new StudentController();
		// studentController4.update(studentEntity4);
		
		// list
		// StudentController studentController4 = new StudentController();
		// for (StudentEntity temp : studentController4.list()) {
		// System.out.println(temp);
		// }
		
		// hql
		// eclipse üzerinden database bağlanmak CRUD
		// EntityAnotation
		// log4j
		
	}
	
}
