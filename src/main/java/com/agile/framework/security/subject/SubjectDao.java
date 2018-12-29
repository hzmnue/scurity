package com.agile.framework.security.subject;

import com.agile.framework.security.session.Session;

import java.util.Collection;

public interface SubjectDao {
    public Subject getSubjct(String  tokenId);

    public Subject invalidSubject(String tokenId);

    public Subject createSubject(String  tokenId);

    public Collection<Subject> getAllSubject();
}
