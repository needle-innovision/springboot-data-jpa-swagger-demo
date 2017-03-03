package com.needle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.needle.model.Book;

/**
 * Repository that creates the end points for the api
 * 
 * @author sandeepknair
 *
 */
public interface BookRepository extends JpaRepository<Book, Long>{

}
