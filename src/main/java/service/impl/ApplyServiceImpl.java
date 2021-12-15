package service.impl;

import VO.ApplyVO;
import entity.Apply;
import mapper.ApplyMapper;
import mapper.impl.ApplyMapperImpl;
import service.ApplyService;
import util.TrainingContext;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public Map<String, Object> selectAllApply() {
        Map<String,Object> map = new HashMap<>();
        List<Apply> applyList = applyMapper.selectAll();
        StringBuilder builder = new StringBuilder();
        if (applyList.isEmpty()){
            map.put("value","No");
        }else{
            map.put("value","Yes");
            for (Apply apply : applyList){
                builder.append(apply.toString());
            }
            map.put("data",builder.toString());
        }
        return map;
    }
}
