
package com.fbty.base.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author liyun 
 * @date   Dec 13, 2008
 *
 */
public class Page implements Serializable {
	private static final long serialVersionUID = 9030682628072361206L;
	public final static int DEFAULT_PAGE_SIZE = 15;// 默认每页的记录数
	private List result; // 本页包含的数据
	private int start; // 本页在数据集中的起始位置
	private int pageSize = DEFAULT_PAGE_SIZE; // 每页的记录数
	private int totalCount;// 总记录数

	/**
	 * 构造函数 - 空页
	 */
	public Page() {
		this(new ArrayList(), 0, 0, DEFAULT_PAGE_SIZE);
	}

	/**
	 * 构造函数 - 默认
	 * 
	 * @param result 本页包含的数据
	 * @param start 本页在数据集中的起始位置
	 * @param totalCount 数据库记录数
	 * @param pageSize 页容量
	 */
	public Page(List results, int start, int totalCount, int pageSize) {
		if (results == null) {
			this.result = new ArrayList();
		}
		else if (results.size() <= pageSize) {
			this.result = results;
		} else {
			this.result = new ArrayList();
			for (int i = start; (i < start + pageSize) && (i < results.size()); i++)
				this.result.add(results.get(i));
		}
		this.start = start;
		this.pageSize = (pageSize > 0) ? pageSize : DEFAULT_PAGE_SIZE;
		this.totalCount = totalCount;
	}

	/**
	 * 当前页
	 */
	public int getCurrentPageNo() {
		return start / pageSize + 1;
	}

	/**
	 * 获取最大页/总页数
	 */
	public int getLastPageNo() {
		return (totalCount + pageSize - 1) / pageSize;
	}

	/**
	 * 当前页记录
	 */
	public List getResult() {
		return result;
	}

	/**
	 * 取数据库中包含的总记录数
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * 判断是否有下一页
	 */
	public boolean hasNextPage() {
		return getCurrentPageNo() < getLastPageNo();
	}

	/**
	 * 判断是否有前一页
	 */
	public boolean hasPrevPage() {
		return getCurrentPageNo() > 1;
	}

	/**
	 * 获取指定页在数据集中的起始位置,每页条数使用默认值(从0开始)
	 */
	public static int getStartOfPage(int pageNo) {
		return getStartOfPage(pageNo, DEFAULT_PAGE_SIZE);
	}

	/**
	 * 获取指定页在数据集中的起始位置(从0开始)
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public static int getStartOfPage(int pageNo, int pageSize) {
		return Math.max((pageNo - 1) * pageSize, 0);
	}

	/**
	 * @see java.lang.Object#toString()
	 */


	public void setResult(List results) {
	 this.result = results;
	 }
	// /**
	// * 获取下一页的记录起始位置
	// */
	// public static int getStartOfNextPage() {
	// return Math.max(start + pageSize, totalCount);
	// }
	//
	// /**
	// * 获取上一页的记录起始位置
	// */
	// public static int getStartOfPrevPage() {
	// return Math.max(start - pageSize, 1);
	// }

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Page [pageSize=" + pageSize + ", result=" + result + ", start="
				+ start + ", totalCount=" + totalCount + "]";
	}

}
