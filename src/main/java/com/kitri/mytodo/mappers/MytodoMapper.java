package com.kitri.mytodo.mappers;

import com.kitri.mytodo.dto.MemberInfo;
import com.kitri.mytodo.dto.RequestTodo;
import com.kitri.mytodo.dto.ResponseTodo;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface MytodoMapper {

    //전체 회원 정보
    List<MemberInfo> memberInfo();

    //회원 추가
    void memberSave(MemberInfo memberInfo);
    //Todo전체조회
    List<ResponseTodo> findAll();
    //Todo저장
    void save(RequestTodo todo);
    //Todo수정
    void update(RequestTodo todo);
    //Todo삭제
    void delete(Long id);

}
