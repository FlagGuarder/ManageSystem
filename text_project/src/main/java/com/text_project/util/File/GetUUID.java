package com.text_project.util.File;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.UUID;

/**
 * 生成32位唯一标识码，用于标识文件
 * @author peng
 */
public class GetUUID {

    public static String get(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
