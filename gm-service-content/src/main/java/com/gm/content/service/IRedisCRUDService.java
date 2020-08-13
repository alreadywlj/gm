package com.gm.content.service;

import com.gm.content.domain.Dictionary;

public interface IRedisCRUDService {

    public Dictionary selectDictionary(String id);

}
