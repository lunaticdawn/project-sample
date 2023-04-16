package com.project.cmn.sample.tree.controller;

import com.project.cmn.sample.tree.dto.TbMenuDto;
import com.project.cmn.sample.tree.service.TbMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TbMenuController {
    private final TbMenuService tbMenuService;

    @GetMapping("/sample/tree")
    public List<TbMenuDto> retrieveAvailableTbMenuList() {
        return tbMenuService.retrieveAvailableTbMenuList();
    }
}
