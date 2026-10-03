package com.framework.common.tools;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.HashSet;
import java.util.Set;

public class BeanUtils {
   public static void copyProperties(Object source, Object target,String[] initialIgnoreProperties){
       final BeanWrapper src = new BeanWrapperImpl(source);
       java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
       Set<String> nullAndIgnoreProperties = new HashSet<String>();
       for (String item: initialIgnoreProperties){
           nullAndIgnoreProperties.add(item);
       }
       for(java.beans.PropertyDescriptor pd : pds) {
           String propertyName = pd.getName();
           Object srcValue = src.getPropertyValue(propertyName);
           if (srcValue == null) {
               nullAndIgnoreProperties.add(pd.getName());
               continue;
           }
           if ("".equals(srcValue)) {
               src.setPropertyValue(propertyName,null);
           }
       }
//       String[] ignoreProperties = initialIgnoreProperties;
       String[] ignoreProperties = nullAndIgnoreProperties.toArray(new String[nullAndIgnoreProperties.size()]);

       org.springframework.beans.BeanUtils.copyProperties(source, target, ignoreProperties);
   }
   public static void setPropertiesNullIfEmpty(Object object){
       if(null == object) return;
       final BeanWrapper src = new BeanWrapperImpl(object);
       java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
       for(java.beans.PropertyDescriptor pd : pds) {
           String propertyName = pd.getName();
           Object srcValue = src.getPropertyValue(propertyName);
           if ("".equals(srcValue)) {
               src.setPropertyValue(propertyName,null);
           }
       }
   }
}
