package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.example.demo.dto.StudentAlnDto;
import com.example.demo.enity.StudentEnity;
@Repository
public interface StudentRepository extends JpaRepository<StudentEnity, String> {
	@Query(value = "SELECT *"+ 
		    " FROM student n where name is not null ORDER BY n.time_create desc"+ 
		    " OFFSET (:pagenumber -1)*:rowsofpage ROWS FETCH NEXT :rowsofpage ROWS ONLY", nativeQuery = true)
	public List<StudentEnity> pageableStudent(@Param("pagenumber") int pagenumber,@Param("rowsofpage")  int rowsofpage);
	
//	@Query(value = "select"+ 
//		    " new com.example.baitap.dto.StudentAlnDto(count(s.class_id),c.name, d.name)"+
//		    " from StudentEnity s inner join ClassEnity c on s.class_id=c.id inner join DepartmentEnity d on d.id=c.department_Id"+ 
//		    " where trunc(to_number(sysdate - to_date(s.birthdate)) / 365.25) BETWEEN ?1 and ?2 group by s.class_id,c.name,d.name")
//		    public List<StudentAlnDto> analyList(int startAge,int endAge);  
//	
//
//	 //Page<StudentEnity> findAll(Pageable pageable);
//	@Query(value = "select" + " new com.example.baitap.Dto.StudentAlnDto(count(s.class_id),c.name, d.name)"
//            + " from StudentEnity s inner join ClassEnity c on s.class_id=c.id inner join DepartmentEnity d on d.id=c.department_id"
//            + " where ((:name IS NULL) or (s.name like %:name%) )"
//            + " and ((:department_id IS NULL)or(d.id = :department_Id))"
//            + " and ((:class_id IS NULL)or(c.id= :class_id) )"
//            + " and ((:gender IS NULL)or(s.gender = TO_NUMBER(:gender)))"
//            + " and ((:startAge is NULL) or (trunc(to_number(sysdate - to_date(s.birthdate)) / 365.25)"
//            + " BETWEEN :startAge and :endAge))" + " group by s.class_id,c.name,d.name")
//public List<StudentAlnDto> findList(@Param("name") String name, @Param("department_id") String department_id,
//            @Param("class_id") String class_id, @Param("gender") String gender,
//            @Param("startAge") int startAge, @Param("endAge") int endAge);
//	 List<StudentEnity> findAll();


}
