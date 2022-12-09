package com.sparta.projectmemo.controller;


import com.sparta.projectmemo.service.MemoService;
import com.sparta.projectmemo.domain.Memo;
import com.sparta.projectmemo.dto.MemoRequestDto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoController {

    private final MemoService memoService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        return memoService.createMemo(requestDto);
    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        return memoService.getMemos();
    }

    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.update(id, requestDto);
    }

    @DeleteMapping("/api/memos/{id}")
    public Long deleteMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto) {
        return memoService.deleteMemo(id, requestDto);
    }

}