package com.sparta.projectmemo.domain;



import com.sparta.projectmemo.dto.MemoRequestDto;
import com.sparta.projectmemo.utils.Timestamped;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Memo extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;



    public Memo(String title,String contents,String username, String password) {
        this.title = title;
        this.contents = contents;
        this.username = username;
        this.password = password;
    }

    public Memo(MemoRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
    }

    public void update(MemoRequestDto memoRequestDto) {
        this.title = memoRequestDto.getTitle();
        this.contents = memoRequestDto.getContents();
        this.username = memoRequestDto.getUsername();
        this.password = memoRequestDto.getPassword();
    }
}