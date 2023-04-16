package com.project.cmn.sample.tree.mapper;

import com.project.cmn.sample.tree.dto.TbMenuDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbMenuMapper {
    /**
     * 사용가능한 메뉴 목록을 조회한다.
     *
     * @return 사용가능한 메뉴 목록
     */
    List<TbMenuDto> selectAvailableTbMenuList();
}
