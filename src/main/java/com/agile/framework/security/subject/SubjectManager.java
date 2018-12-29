package com.agile.framework.security.subject;

public interface SubjectManager  {

    public String createTokenId();

    public Subject getSubject(String tokenId);

    public void flushSubject();

    public Subject invalidSubject(String tokenId);

    public Subject createSubject();

    public void setSubjectDao(SubjectDao tokenId);
}
