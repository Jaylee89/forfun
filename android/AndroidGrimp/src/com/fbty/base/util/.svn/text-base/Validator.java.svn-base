package com.fbty.base.util;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 验证工具类
 */
public class Validator {
	/**
	 * 验证valu值是否为空
	 * @param value 需要验证的值
	 * @return true：为空、false：非空
	 */
	public static boolean isNull( Object value ){
		if( value == null )return true;
		if( value instanceof String && "".equalsIgnoreCase( value.toString().trim() )){
			return true;
		}
		return false;
	}
	
	/**
	 * 验证value值是否是正整数
	 * @param value 需要验证的值
	 * @return true：正整数、false：非正整数
	 */
	public static boolean isPositiveInt( Number value ){
		if( isNull(value) )return false;
		Pattern regex = Pattern.compile( "^[1-9]\\d*$" ); 
		Matcher matcher = regex.matcher( value.toString() );
		if( matcher.matches() ){
			return true;
		}
		return false;
	}
	
	/**
	 * 验证value值是否是正整数
	 * @param value 需要验证的值
	 * @return true：正整数、false：非正整数
	 */
	public static boolean isPositiveInt( String value ){
		if( isNull(value) )return false;
		Pattern regex = Pattern.compile( "^[1-9]\\d*$" ); 
		Matcher matcher = regex.matcher( value );
		if( matcher.matches() ){
			return true;
		}
		return false;
	}
	
	/**
	 * 验证value值是否在指定的范围类
	 * @param value 需要验证的值
	 * @param min 最小直(null：不限制最小值)
	 * @param max 最大值(null：不限制最大值)
	 * @return true：满足、false：不满足
	 */
	public static boolean isInScope( Number value, Object min, Object max ){
		if( isNull(value) )return false;
		if( min != null && !(min instanceof Number) )throw new RuntimeException( "参数值  min 的类型错误." );
		if( max != null && !(max instanceof Number) )throw new RuntimeException( "参数值  max 的类型错误." );
		if( min == null && max != null ){
			if( value.doubleValue() > ((Number)max).doubleValue() )return false;
		}else if( min != null && max == null ){
			if( value.doubleValue() < ((Number)min).doubleValue() )return false;
		}else if( min != null && max != null ){
			if(	value.doubleValue() < ((Number)min).doubleValue() 
				|| 
				value.doubleValue() > ((Number)max).doubleValue()
			){return false;}
		}
		return true;
	}
	
	/**
	 * 验证value值是否在指定的范围类
	 * @param value 需要验证的值
	 * @param min 最小直(null：不限制最小值)
	 * @param max 最大值(null：不限制最大值)
	 * @return true：满足、false：不满足
	 */
	public static boolean isInScope( String value, Object min, Object max ){
		if( isNull(value) )return false;
		if( min != null && !(min instanceof Number) )throw new RuntimeException( "参数值  min 的类型错误." );
		if( max != null && !(max instanceof Number) )throw new RuntimeException( "参数值  max 的类型错误." );
		if( min == null && max != null ){
			if( value.length() > ((Number)max).doubleValue() )return false;
		}else if( min != null && max == null ){
			if( value.length() < ((Number)min).doubleValue() )return false;
		}else if( min != null && max != null ){
			if(	value.length() < ((Number)min).doubleValue() 
				|| 
				value.length() > ((Number)max).doubleValue()
			){return false;}
		}
		return true;
	}
	
	/**
	 * 验证指定数组的长度
	 * @param array 需要验证的数组
	 * @param min 最小长度(null：不限制最小长度)
	 * @param max 最大长度(null：不限制最大长度)
	 * @return true：满足、false：不满足
	 */
	public static boolean checkLength( Object[] array, Object min, Object max ){
		if( isNull(array) )return false;
		if( min != null && !(min instanceof Number) )throw new RuntimeException( "参数值  min 的类型错误." );
		if( max != null && !(max instanceof Number) )throw new RuntimeException( "参数值  max 的类型错误." );
		if( min == null && max != null ){
			if( array.length > ((Number)max).intValue() )return false;
		}else if( min != null && max == null ){
			if( array.length < ((Number)min).intValue() )return false;
		}else if( min != null && max != null ){
			if(	array.length < ((Number)min).intValue() 
				|| 
				array.length > ((Number)max).intValue()
			){return false;}
		}
		return true;
	}
	
	/**
	 * 验证指定集合的长度
	 * @param array 需要验证的集合
	 * @param min 最小长度(null：不限制最小长度)
	 * @param max 最大长度(null：不限制最大长度)
	 * @return true：满足、false：不满足
	 */
	public static boolean checkSize( Collection<?> collection, Object min, Object max ){
		if( isNull(collection) )return false;
		if( min != null && !(min instanceof Number) )throw new RuntimeException( "参数值  min 的类型错误." );
		if( max != null && !(max instanceof Number) )throw new RuntimeException( "参数值  max 的类型错误." );
		if( min == null && max != null ){
			if( collection.size() > ((Number)max).intValue() )return false;
		}else if( min != null && max == null ){
			if( collection.size() < ((Number)min).intValue() )return false;
		}else if( min != null && max != null ){
			if(	collection.size() < ((Number)min).intValue() 
				|| 
				collection.size() > ((Number)max).intValue()
			){return false;}
		}
		return true;
	}
	
	/**
	 * 正则表达式验证
	 * @param value 需要验证的值
	 * @param rule 正则规则
	 * @return true：满足、false：不满足
	 */
	public static boolean regexCheck( String value, String rule ){
		Pattern regex = Pattern.compile( rule ); 
		Matcher matcher = regex.matcher( value );
		if( matcher.matches() ){
			return true;
		}
		return false;
	}
}