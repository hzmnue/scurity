package com.agile.framework.security.subject.impl.manager;

import com.agile.framework.security.common.Constants;
import com.agile.framework.security.subject.Subject;
import com.agile.framework.security.subject.SubjectDao;
import com.agile.framework.security.subject.SubjectManager;
import com.agile.framework.security.utils.MD5Util;

import java.util.concurrent.atomic.AtomicInteger;

public class DefaultSubjectManager implements SubjectManager {

    private SubjectDao subjectDao;
    private AtomicInteger idSeed=new AtomicInteger(0);
    private long expireTime=1000*60*20;

    @Override
    public String createTokenId() {
        String subjectId= System.currentTimeMillis()+ Constants.SUFFIX+idSeed;
        subjectId= MD5Util.encode(subjectId);
        return subjectId;
    }

    @Override
    public Subject getSubject(String tokenId) {
        return subjectDao.getSubjct(tokenId);
    }

    //如果有过期时间,按过期时间判断是否删除subject
    //如果没有,按subject管理里设置的多久没活动便注销subject
    @Override
    public void flushSubject() {
        for (Subject subject : subjectDao.getAllSubject()) {

                //subjectDao.invalidSubject(subject.g)

        }
    }

    @Override
    public Subject invalidSubject(String subjectId) {
        return null;
    }

    @Override
    public Subject createSubject() {
     //   String subjectId= this.createSubjectId();
      //  Subject subject= subjectDao.createSubject(subjectId);
        return null;
    }

    @Override
    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    public void setExpireTime(long expireTime) {
        this.expireTime = expireTime;
    }
}
