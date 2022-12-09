package com.sparta.projectmemo.service;


import com.sparta.projectmemo.dto.MemoRequestDto;
import com.sparta.projectmemo.domain.Memo;
import com.sparta.projectmemo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Memo createMemo(MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        memoRepository.save(memo);
        return memo;
    }

    @Transactional(readOnly = true)
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByModifiedAtDesc();
    }

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        if(requestDto.getPassword().equals(memo.getPassword()) == false)
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");
        memo.update(requestDto);

        return memo.getId();
    }

    @Transactional
    public Long deleteMemo(Long id, MemoRequestDto requestDto) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        if(requestDto.getPassword().equals(memo.getPassword()) == false)
            throw new IllegalArgumentException("비밀번호가 틀렸습니다.");

        memoRepository.deleteById(id);
        return id;
    }

}