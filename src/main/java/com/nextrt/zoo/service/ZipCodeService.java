package com.nextrt.zoo.service;

import com.alibaba.fastjson.JSONObject;

public interface ZipCodeService {
    JSONObject zipCodeSearch(String postcode);
}
