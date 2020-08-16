package com.gm.content.service;

import com.gm.content.domain.Dictionary;

public interface IRedisCRUDService {

    public Dictionary selectDictionary(int id);

    public void delDictionary(int id);

    public Dictionary updateDictionary(int id,Dictionary dictionary);
}
