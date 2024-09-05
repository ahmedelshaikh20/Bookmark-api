package com.ahmed.bookmarker_api.domian;

import com.ahmed.bookmarker_api.domian.databasemodel.BookmarkDomainModel;
import com.ahmed.bookmarker_api.domian.bookmarkDbModel.BookMarksDTO;
import com.ahmed.bookmarker_api.domian.mappers.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookMarkService {

  private final BookMarkRepository repo;
  private final Mapper mapper;



  @Transactional(readOnly = true)
  public BookMarksDTO getBookMarks(Integer page) {
    int pageNo = page <1 ?0: page-1;
    Pageable pageable= PageRequest.of(pageNo , 2);
    Page<BookmarkDomainModel> res = repo.findBookMarks(pageable);
    return new BookMarksDTO(res);
  }

}
