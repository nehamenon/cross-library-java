package com.crossover.techtrial.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.crossover.techtrial.model.Book;
import com.crossover.techtrial.repositories.BookRepository;
import com.crossover.techtrial.repositories.TransactionRepository;

public class BookServiceImplTest {

	    @Mock
	    private BookServiceImpl bookService;

	    @Spy
	    private BookRepository bookRepo;

	    @Mock
	    private TransactionRepository tranRepo;

	    @Before
	    public void initMocks(){
	        MockitoAnnotations.initMocks(this);
	    }

	    @Test
	    public void testGetOrderService(){
	    	Book book = new Book();
			book.setId(1234L);
			book.setTitle("Tom Sawyer");
	        Mockito.when(bookService.findById(1234L)).thenReturn(book);

	        //notice different Mockito syntax for spy
	        
	        assertEquals(new Long(1234L),bookService.findById(1234L).getId());
	        
	        Optional<Book> bookOpt = Optional.ofNullable(book);
	        Mockito.when(bookRepo.findById(1234L)).thenReturn(bookOpt);
	        
	        assertEquals(new Long(1234L),bookRepo.findById(1234L).get().getId());

	        Mockito.when(bookRepo.save(book)).thenReturn(book);
	        
	    }
	
}
