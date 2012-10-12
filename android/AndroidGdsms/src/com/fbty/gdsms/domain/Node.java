package com.fbty.gdsms.domain;

public class Node {
	private Integer id;
	private String name ;
	private boolean leaf;
	private Integer superId;
	private int level;
	private boolean select;
	private boolean expanded;
	private String specifiedNum;
	
	public String getSpecifiedNum() {
		return specifiedNum;
	}
	public void setSpecifiedNum(String specifiedNum) {
		this.specifiedNum = specifiedNum;
	}
	public Node(){};
	public Node(Integer id, String name, Integer parent) {
		super();
		this.id = id;
		this.name = name;
		this.superId = parent;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public Integer getSuperId() {
		return superId;
	}
	public void setSuperId(Integer superId) {
		this.superId = superId;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public boolean isSelect() {
		return select;
	}
	public void setSelect(boolean select) {
		this.select = select;
	}
	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
	@Override
	public String toString() {
		return "Node [expanded=" + expanded + ", id=" + id + ", leaf=" + leaf
				+ ", level=" + level + ", name=" + name + ", select=" + select
				+ ", specifiedNum=" + specifiedNum + ", superId=" + superId
				+ "]";
	}


}
