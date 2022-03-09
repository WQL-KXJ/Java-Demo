package com.util;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;



//自定义逻辑返回需要导入的组件
public class importselect_util implements ImportSelector {

    /*
    * AnnotationMetadata：获取到当前标注@import注解类的全部注解信息
    * */
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        //返回值就是要导入容器中的组件全类名数组
        return new String[]{"com.util.condition_lin_util","com.util.condition_win_util"};
    }

}
