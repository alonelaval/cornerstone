//package com.alonelaval.cornerstone.entity.converter;
//
//import com.alonelaval.cornerstone.entity.constants.UserLoginType;
//
//import javax.persistence.AttributeConverter;
//import javax.persistence.Converter;
//
///**
// * @author huawei
// * @create 2018-07-28
// **/
//@Converter(autoApply = true)
//public class UserLoginTypeConverter implements AttributeConverter<UserLoginType, Integer> {
//    @Override
//    public Integer convertToDatabaseColumn(UserLoginType attribute) {
//        return attribute.value();
//    }
//
//    @Override
//    public UserLoginType convertToEntityAttribute(Integer dbData) {
//    	if(dbData == null) {
//            return null;
//        }
//        return UserLoginType.valueOf(dbData);
//    }
//}
