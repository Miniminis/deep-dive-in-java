package me.flash.springdi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiService {

    @Autowired
    DiRepository diRepository;

}
