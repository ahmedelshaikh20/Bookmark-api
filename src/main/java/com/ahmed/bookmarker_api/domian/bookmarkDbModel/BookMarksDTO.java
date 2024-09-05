package com.ahmed.bookmarker_api.domian.bookmarkDbModel;

import com.ahmed.bookmarker_api.domian.databasemodel.BookmarkDomainModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@Setter
@Getter

public class BookMarksDTO {
  private List<BookmarkDomainModel> data;
  private long totalElements;
  private int pageNumber;
  private boolean isFirst;
  private boolean hasNext;
  private boolean hasPrevious;

  public BookMarksDTO(Page<BookmarkDomainModel> bookMarkPage) {
    this.setData(bookMarkPage.getContent());
    this.setTotalElements(bookMarkPage.getTotalElements());
    this.setFirst(bookMarkPage.isFirst());
    this.setHasNext(bookMarkPage.hasNext());
    this.setHasPrevious(bookMarkPage.hasPrevious());
  }

}
