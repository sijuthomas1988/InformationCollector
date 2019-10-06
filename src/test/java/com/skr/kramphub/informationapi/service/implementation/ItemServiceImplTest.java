package com.skr.kramphub.informationapi.service.implementation;

import com.skr.kramphub.informationapi.exception.ApiException;
import com.skr.kramphub.informationapi.exception.ServiceException;
import com.skr.kramphub.informationapi.model.Album;
import com.skr.kramphub.informationapi.model.Book;
import com.skr.kramphub.informationapi.model.ItemResponse;
import com.skr.kramphub.informationapi.service.ApiService;
import com.skr.kramphub.informationapi.service.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class ItemServiceImplTest {

    @Spy
    private ApiService apiService;

    @Mock
    private CompletableFuture<List<Book>> listOfBooks;

    @Mock
    private CompletableFuture<List<Album>> listOfAlbum;

    @InjectMocks
    private ItemServiceImpl itemService;

    @Before
    public void setUp() throws Exception {
        List<Book> bookList = createBooks();
        List<Album> albumList = createAlbums();
        listOfBooks = CompletableFuture.completedFuture(bookList);
        listOfAlbum = CompletableFuture.completedFuture(albumList);

    }

    @Test
    public void getItems_success() throws ApiException, ServiceException {
        Mockito.doReturn(listOfBooks).when(apiService).getBooks("da");
        Mockito.doReturn(listOfAlbum).when(apiService).getAlbums("da");

        final List<ItemResponse> itemResponses = itemService.getItems("da");
        assertNotNull(itemResponses);
        assertEquals(itemResponses.get(0).getTitle(), "title1");
    }

    private List<Book> createBooks() {
        List<Book> bookList = new ArrayList<>();
        Book book = new Book();
        book.setTitle("title1");
        book.setAuthors(Arrays.asList(new String[]{"author1"}));
        book.setPrintType("booktype");
        Book book2 = new Book();
        book2.setTitle("title2");
        book2.setAuthors(Arrays.asList(new String[]{"author2"}));
        book2.setPrintType("booktype");
        Book book3 = new Book();
        book3.setTitle("title3");
        book3.setAuthors(Arrays.asList(new String[]{"author3"}));
        book3.setPrintType("booktype");
        bookList.add(book);
        bookList.add(book2);
        bookList.add(book3);
        return bookList;
    }

    private List<Album> createAlbums() {
        List<Album> albumList = new ArrayList<>();
        Album album = new Album();
        album.setKind("album");
        album.setTrackName("track");
        album.setArtistName("artist");
        Album album1 = new Album();
        album1.setKind("album1");
        album1.setTrackName("track1");
        album1.setArtistName("artist & artist1");
        Album album2 = new Album();
        album2.setKind("album");
        album2.setTrackName("track1");
        album2.setArtistName("artist");
        albumList.add(album);
        albumList.add(album1);
        albumList.add(album2);
        return albumList;
    }
}