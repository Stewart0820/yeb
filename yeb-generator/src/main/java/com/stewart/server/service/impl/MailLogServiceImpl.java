package com.stewart.server.service.impl;

import com.stewart.server.pojo.MailLog;
import com.stewart.server.mapper.MailLogMapper;
import com.stewart.server.service.IMailLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenhongjie
 * @since 2021-11-20
 */
@Service
public class MailLogServiceImpl extends ServiceImpl<MailLogMapper, MailLog> implements IMailLogService {

}
