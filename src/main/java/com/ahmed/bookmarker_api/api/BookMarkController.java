package com.ahmed.bookmarker_api.api;


import com.ahmed.bookmarker_api.domian.BookMarkService;
import com.ahmed.bookmarker_api.domian.bookmarkDbModel.BookMarksDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookmarks")
public class BookMarkController {

  private final BookMarkService bookMarkService;


  public BookMarkController(BookMarkService bookMarkService) {
    this.bookMarkService = bookMarkService;
  }

  @GetMapping
  public ResponseEntity<BookMarksDTO> getAllBookMarks(@RequestParam(name = "page", defaultValue = "1") Integer page) {
    return ResponseEntity.ok(bookMarkService.getBookMarks(page));
  }

}
