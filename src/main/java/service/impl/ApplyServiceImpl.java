package service.impl;

import VO.ApplyVO;
import entity.Apply;
import mapper.ApplyMapper;
import mapper.impl.ApplyMapperImpl;
import service.ApplyService;
import util.TrainingContext;

import java.sql.Date;

public class ApplyServiceImpl implements ApplyService {
    private ApplyMapper applyMapper = new ApplyMapperImpl();

    @Override
    public void addApply(ApplyVO applyVO) {
        Apply apply = new Apply();
        apply.setCause(applyVO.getCause());
        apply.setTime(new Date(System.currentTimeMillis()));
        apply.setUsername(TrainingContext.getLocal_User_Name());
        apply.setActivityId(applyVO.getActivity_id());
        applyMapper.insert(apply);
    }
}
