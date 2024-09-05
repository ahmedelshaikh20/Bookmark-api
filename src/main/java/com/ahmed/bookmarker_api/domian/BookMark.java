package com.ahmed.bookmarker_api.domian;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "bookmarks")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookMark {
  @Id
  @SequenceGenerator(name = "generator_id", sequenceName = "generator_id_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_id")
  private Long id;

  @Column(nullable = false)
  private String title;
  @Column(nullable = false)
  private String url;
  private Instant createdAt;



  @Override
  public String toString() {
    return "BookMark{" +
      "id=" + id +
      ", title='" + title + '\'' +
      ", url='" + url + '\'' +
      ", CreatedAt=" + createdAt +
      '}';
  }
}
