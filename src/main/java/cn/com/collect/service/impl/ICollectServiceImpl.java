package cn.com.collect.service.impl;

import cn.com.collect.mapper.CollectMapper;
import cn.com.collect.model.Collect;
import cn.com.collect.service.ICollectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ICollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements ICollectService {
}
