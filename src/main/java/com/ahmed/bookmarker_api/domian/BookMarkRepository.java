package com.ahmed.bookmarker_api.domian;

import com.ahmed.bookmarker_api.domian.databasemodel.BookmarkDomainModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookMarkRepository extends JpaRepository<BookMark, Long> {


  @Query("SELECT new com.ahmed.bookmarker_api.domian.databasemodel.BookmarkDomainModel(b.id , b.title , b.url , b.createdAt) from BookMark b ")
  Page<BookmarkDomainModel> findBookMarks(Pageable pageable);


}
