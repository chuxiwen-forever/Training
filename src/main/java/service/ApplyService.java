package service;

import VO.ApplyVO;

import java.util.Map;

public interface ApplyService {

    void addApply(ApplyVO applyVO);

    Map<String,Object> selectAllApply();
}
