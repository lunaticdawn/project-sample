package com.project.cmn.sample.tree.service;

import com.project.cmn.sample.tree.dto.TbMenuDto;
import com.project.cmn.sample.tree.mapper.TbMenuMapper;
import com.project.cmn.util.tree.TreeMaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TbMenuService {
    private final TbMenuMapper tbMenuMapper;

    /**
     * 메뉴를 Tree 형태로 만들어 반환한다.
     *
     * @return Tree 형태로 된 메뉴
     */
    public List<TbMenuDto> retrieveAvailableTbMenuList() {
        List<TbMenuDto> resultList = tbMenuMapper.selectAvailableTbMenuList();
        TreeMaker<TbMenuDto> treeMaker = new TreeMaker<>();

        return treeMaker.getList(resultList);
    }
}
