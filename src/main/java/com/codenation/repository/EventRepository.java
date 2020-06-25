package com.codenation.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.codenation.entities.ErrorLevel;
import com.codenation.entities.Event;

@Repository
public interface EventRepository extends BaseRepository<Event, Long>{
	
	@Transactional(readOnly = true)
	@Query(nativeQuery = true, value =  "SELECT * FROM Event e "
			+ "WHERE UPPER(e.error_level) LIKE %:level% "
			+ "AND UPPER(e.description) LIKE %:description% "
			+ "AND UPPER(e.log) LIKE %:log% "
			+ "AND UPPER(e.origin) LIKE %:origin% ")
	Page<Event> search(@Param("level") String level, 
			@Param("description") String description, 
			@Param("log")String log, 
			@Param("origin") String origin, 
			Pageable pageable);

}
