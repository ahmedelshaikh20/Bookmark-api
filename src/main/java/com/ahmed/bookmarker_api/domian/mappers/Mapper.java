package com.ahmed.bookmarker_api.domian.mappers;

import com.ahmed.bookmarker_api.domian.BookMark;
import com.ahmed.bookmarker_api.domian.databasemodel.BookmarkDomainModel;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

  public BookmarkDomainModel toBookMarksDbModel(BookMark bookMark) {

    return new BookmarkDomainModel(bookMark.getId(), bookMark.getTitle(), bookMark.getUrl(), bookMark.getCreatedAt());
  }

}
