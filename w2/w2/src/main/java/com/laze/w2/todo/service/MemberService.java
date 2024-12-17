package com.laze.w2.todo.service;

import com.laze.w2.todo.dao.MemberDAO;
import com.laze.w2.todo.domain.MemberDTO;
import com.laze.w2.todo.domain.MemberVO;
import com.laze.w2.todo.util.MapperUtil;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;

@Log4j2
public enum MemberService {
    INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService() {

        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();

    }

    public MemberDTO login(String mid, String mpw) throws Exception {

        MemberVO memberVO = dao.getWithPassword(mid, mpw);

        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);

        return memberDTO;

    }

    public void updateUuid(String mid, String uuid) throws Exception {

        dao.updateUuid(mid, uuid);

    }

    public MemberDTO getByUUID(String uuid) throws Exception {

        MemberVO memberVO = dao.selectUUID(uuid);

        MemberDTO memberDTO = modelMapper.map(memberVO, MemberDTO.class);

        return memberDTO;

    }

}
