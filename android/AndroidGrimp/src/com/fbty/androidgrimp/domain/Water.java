package com.fbty.androidgrimp.domain;

// default package

import java.util.Date;

/**
 * Water entity. @author MyEclipse Persistence Tools
 */

public class Water implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String number;
	private String wildNumber;
	private String location;
	private Date searchTime;
	private String viewHeight;
	private String longitude;
	private String latitude;
	private String coordinatesX;
	private String coordinatesY;
	private String trafficState;
	private String dataHead;
	private String backdrop;
	private String stratumSymbol;
	private String geoYear;
	private Date firstTime;
	private String firstHuman;
	private String inquirerHuman;
	private String protectActuality;
	private String protectActualityDesc;
	private String developmentActuality;
	private String developmentActualityDesc;
	private String causes;
	private String shape;
	private String remark;
	private String scienceStudy;
	private String sciencePopular;
	private String scienceTypical;
	private String scienceRare;
	private String scienceComplete;
	private String scienceCapacity;
	private String natureGeography;
	private String natureTravel;
	private String natureQuality;
	private String natureFragile;
	private String natureSecurity;
	private String viewImage;
	private String viewColor;
	private String viewDynamic;
	private String viewPleasure;
	private String viewStrange;
	private String viewScale;
	private String levels;
	private String altitude;
	private String flow;
	private String waterTemperature;
	private String depth;
	private String areas;
	private String spewingHeight;
	private String salinity;
	private String ph;
	private String emissionShape;
	private String bedStone;
	private String waterSurfaceElevation;
	private String width;
	private String capacity;
	private String catchmentArea;
	private String waterQuality;
	private String microLandform;
	private String pollution;
	private String waterLevelChange;
	private String slope;
	private String flowSpeed;
	private String curvature;
	private String bestVisitTime;
	private String visitMethod;
	private String floatCondition;
	private String len;
	private String gap;
	private String downWaterLevel;
	private String drySeasonFlow;
	private String waterfallType;
	private String avgFlow;
	private String age;
	private String springType;

	// Constructors

	/** default constructor */
	public Water() {
	}

	/** full constructor */
	public Water(String name, String number, String wildNumber,
			String location, Date searchTime, String viewHeight,
			String longitude, String latitude, String coordinatesX,
			String coordinatesY, String trafficState, String dataHead,
			String backdrop, String stratumSymbol, String geoYear,
			Date firstTime, String firstHuman, String inquirerHuman,
			String protectActuality, String protectActualityDesc,
			String developmentActuality, String developmentActualityDesc,
			String causes, String shape, String remark, String scienceStudy,
			String sciencePopular, String scienceTypical, String scienceRare,
			String scienceComplete, String scienceCapacity,
			String natureGeography, String natureTravel, String natureQuality,
			String natureFragile, String natureSecurity, String viewImage,
			String viewColor, String viewDynamic, String viewPleasure,
			String viewStrange, String viewScale, String levels,
			String altitude, String flow, String waterTemperature,
			String depth, String areas, String spewingHeight, String salinity,
			String ph, String emissionShape, String bedStone,
			String waterSurfaceElevation, String width, String capacity,
			String catchmentArea, String waterQuality, String microLandform,
			String pollution, String waterLevelChange, String slope,
			String flowSpeed, String curvature, String bestVisitTime,
			String visitMethod, String floatCondition, String len, String gap,
			String downWaterLevel, String drySeasonFlow, String waterfallType,
			String avgFlow, String age, String springType) {
		this.name = name;
		this.number = number;
		this.wildNumber = wildNumber;
		this.location = location;
		this.searchTime = searchTime;
		this.viewHeight = viewHeight;
		this.longitude = longitude;
		this.latitude = latitude;
		this.coordinatesX = coordinatesX;
		this.coordinatesY = coordinatesY;
		this.trafficState = trafficState;
		this.dataHead = dataHead;
		this.backdrop = backdrop;
		this.stratumSymbol = stratumSymbol;
		this.geoYear = geoYear;
		this.firstTime = firstTime;
		this.firstHuman = firstHuman;
		this.inquirerHuman = inquirerHuman;
		this.protectActuality = protectActuality;
		this.protectActualityDesc = protectActualityDesc;
		this.developmentActuality = developmentActuality;
		this.developmentActualityDesc = developmentActualityDesc;
		this.causes = causes;
		this.shape = shape;
		this.remark = remark;
		this.scienceStudy = scienceStudy;
		this.sciencePopular = sciencePopular;
		this.scienceTypical = scienceTypical;
		this.scienceRare = scienceRare;
		this.scienceComplete = scienceComplete;
		this.scienceCapacity = scienceCapacity;
		this.natureGeography = natureGeography;
		this.natureTravel = natureTravel;
		this.natureQuality = natureQuality;
		this.natureFragile = natureFragile;
		this.natureSecurity = natureSecurity;
		this.viewImage = viewImage;
		this.viewColor = viewColor;
		this.viewDynamic = viewDynamic;
		this.viewPleasure = viewPleasure;
		this.viewStrange = viewStrange;
		this.viewScale = viewScale;
		this.levels = levels;
		this.altitude = altitude;
		this.flow = flow;
		this.waterTemperature = waterTemperature;
		this.depth = depth;
		this.areas = areas;
		this.spewingHeight = spewingHeight;
		this.salinity = salinity;
		this.ph = ph;
		this.emissionShape = emissionShape;
		this.bedStone = bedStone;
		this.waterSurfaceElevation = waterSurfaceElevation;
		this.width = width;
		this.capacity = capacity;
		this.catchmentArea = catchmentArea;
		this.waterQuality = waterQuality;
		this.microLandform = microLandform;
		this.pollution = pollution;
		this.waterLevelChange = waterLevelChange;
		this.slope = slope;
		this.flowSpeed = flowSpeed;
		this.curvature = curvature;
		this.bestVisitTime = bestVisitTime;
		this.visitMethod = visitMethod;
		this.floatCondition = floatCondition;
		this.len = len;
		this.gap = gap;
		this.downWaterLevel = downWaterLevel;
		this.drySeasonFlow = drySeasonFlow;
		this.waterfallType = waterfallType;
		this.avgFlow = avgFlow;
		this.age = age;
		this.springType = springType;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getWildNumber() {
		return this.wildNumber;
	}

	public void setWildNumber(String wildNumber) {
		this.wildNumber = wildNumber;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getSearchTime() {
		return this.searchTime;
	}

	public void setSearchTime(Date searchTime) {
		this.searchTime = searchTime;
	}

	public String getViewHeight() {
		return this.viewHeight;
	}

	public void setViewHeight(String viewHeight) {
		this.viewHeight = viewHeight;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getCoordinatesX() {
		return this.coordinatesX;
	}

	public void setCoordinatesX(String coordinatesX) {
		this.coordinatesX = coordinatesX;
	}

	public String getCoordinatesY() {
		return this.coordinatesY;
	}

	public void setCoordinatesY(String coordinatesY) {
		this.coordinatesY = coordinatesY;
	}

	public String getTrafficState() {
		return this.trafficState;
	}

	public void setTrafficState(String trafficState) {
		this.trafficState = trafficState;
	}

	public String getDataHead() {
		return this.dataHead;
	}

	public void setDataHead(String dataHead) {
		this.dataHead = dataHead;
	}

	public String getBackdrop() {
		return this.backdrop;
	}

	public void setBackdrop(String backdrop) {
		this.backdrop = backdrop;
	}

	public String getStratumSymbol() {
		return this.stratumSymbol;
	}

	public void setStratumSymbol(String stratumSymbol) {
		this.stratumSymbol = stratumSymbol;
	}

	public String getGeoYear() {
		return this.geoYear;
	}

	public void setGeoYear(String geoYear) {
		this.geoYear = geoYear;
	}

	public Date getFirstTime() {
		return this.firstTime;
	}

	public void setFirstTime(Date firstTime) {
		this.firstTime = firstTime;
	}

	public String getFirstHuman() {
		return this.firstHuman;
	}

	public void setFirstHuman(String firstHuman) {
		this.firstHuman = firstHuman;
	}

	public String getInquirerHuman() {
		return this.inquirerHuman;
	}

	public void setInquirerHuman(String inquirerHuman) {
		this.inquirerHuman = inquirerHuman;
	}

	public String getProtectActuality() {
		return this.protectActuality;
	}

	public void setProtectActuality(String protectActuality) {
		this.protectActuality = protectActuality;
	}

	public String getProtectActualityDesc() {
		return this.protectActualityDesc;
	}

	public void setProtectActualityDesc(String protectActualityDesc) {
		this.protectActualityDesc = protectActualityDesc;
	}

	public String getDevelopmentActuality() {
		return this.developmentActuality;
	}

	public void setDevelopmentActuality(String developmentActuality) {
		this.developmentActuality = developmentActuality;
	}

	public String getDevelopmentActualityDesc() {
		return this.developmentActualityDesc;
	}

	public void setDevelopmentActualityDesc(String developmentActualityDesc) {
		this.developmentActualityDesc = developmentActualityDesc;
	}

	public String getCauses() {
		return this.causes;
	}

	public void setCauses(String causes) {
		this.causes = causes;
	}

	public String getShape() {
		return this.shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getScienceStudy() {
		return this.scienceStudy;
	}

	public void setScienceStudy(String scienceStudy) {
		this.scienceStudy = scienceStudy;
	}

	public String getSciencePopular() {
		return this.sciencePopular;
	}

	public void setSciencePopular(String sciencePopular) {
		this.sciencePopular = sciencePopular;
	}

	public String getScienceTypical() {
		return this.scienceTypical;
	}

	public void setScienceTypical(String scienceTypical) {
		this.scienceTypical = scienceTypical;
	}

	public String getScienceRare() {
		return this.scienceRare;
	}

	public void setScienceRare(String scienceRare) {
		this.scienceRare = scienceRare;
	}

	public String getScienceComplete() {
		return this.scienceComplete;
	}

	public void setScienceComplete(String scienceComplete) {
		this.scienceComplete = scienceComplete;
	}

	public String getScienceCapacity() {
		return this.scienceCapacity;
	}

	public void setScienceCapacity(String scienceCapacity) {
		this.scienceCapacity = scienceCapacity;
	}

	public String getNatureGeography() {
		return this.natureGeography;
	}

	public void setNatureGeography(String natureGeography) {
		this.natureGeography = natureGeography;
	}

	public String getNatureTravel() {
		return this.natureTravel;
	}

	public void setNatureTravel(String natureTravel) {
		this.natureTravel = natureTravel;
	}

	public String getNatureQuality() {
		return this.natureQuality;
	}

	public void setNatureQuality(String natureQuality) {
		this.natureQuality = natureQuality;
	}

	public String getNatureFragile() {
		return this.natureFragile;
	}

	public void setNatureFragile(String natureFragile) {
		this.natureFragile = natureFragile;
	}

	public String getNatureSecurity() {
		return this.natureSecurity;
	}

	public void setNatureSecurity(String natureSecurity) {
		this.natureSecurity = natureSecurity;
	}

	public String getViewImage() {
		return this.viewImage;
	}

	public void setViewImage(String viewImage) {
		this.viewImage = viewImage;
	}

	public String getViewColor() {
		return this.viewColor;
	}

	public void setViewColor(String viewColor) {
		this.viewColor = viewColor;
	}

	public String getViewDynamic() {
		return this.viewDynamic;
	}

	public void setViewDynamic(String viewDynamic) {
		this.viewDynamic = viewDynamic;
	}

	public String getViewPleasure() {
		return this.viewPleasure;
	}

	public void setViewPleasure(String viewPleasure) {
		this.viewPleasure = viewPleasure;
	}

	public String getViewStrange() {
		return this.viewStrange;
	}

	public void setViewStrange(String viewStrange) {
		this.viewStrange = viewStrange;
	}

	public String getViewScale() {
		return this.viewScale;
	}

	public void setViewScale(String viewScale) {
		this.viewScale = viewScale;
	}

	public String getLevels() {
		return this.levels;
	}

	public void setLevels(String levels) {
		this.levels = levels;
	}

	public String getAltitude() {
		return this.altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public String getFlow() {
		return this.flow;
	}

	public void setFlow(String flow) {
		this.flow = flow;
	}

	public String getWaterTemperature() {
		return this.waterTemperature;
	}

	public void setWaterTemperature(String waterTemperature) {
		this.waterTemperature = waterTemperature;
	}

	public String getDepth() {
		return this.depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}

	public String getAreas() {
		return this.areas;
	}

	public void setAreas(String areas) {
		this.areas = areas;
	}

	public String getSpewingHeight() {
		return this.spewingHeight;
	}

	public void setSpewingHeight(String spewingHeight) {
		this.spewingHeight = spewingHeight;
	}

	public String getSalinity() {
		return this.salinity;
	}

	public void setSalinity(String salinity) {
		this.salinity = salinity;
	}

	public String getPh() {
		return this.ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

	public String getEmissionShape() {
		return this.emissionShape;
	}

	public void setEmissionShape(String emissionShape) {
		this.emissionShape = emissionShape;
	}

	public String getBedStone() {
		return this.bedStone;
	}

	public void setBedStone(String bedStone) {
		this.bedStone = bedStone;
	}

	public String getWaterSurfaceElevation() {
		return this.waterSurfaceElevation;
	}

	public void setWaterSurfaceElevation(String waterSurfaceElevation) {
		this.waterSurfaceElevation = waterSurfaceElevation;
	}

	public String getWidth() {
		return this.width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getCapacity() {
		return this.capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public String getCatchmentArea() {
		return this.catchmentArea;
	}

	public void setCatchmentArea(String catchmentArea) {
		this.catchmentArea = catchmentArea;
	}

	public String getWaterQuality() {
		return this.waterQuality;
	}

	public void setWaterQuality(String waterQuality) {
		this.waterQuality = waterQuality;
	}

	public String getMicroLandform() {
		return this.microLandform;
	}

	public void setMicroLandform(String microLandform) {
		this.microLandform = microLandform;
	}

	public String getPollution() {
		return this.pollution;
	}

	public void setPollution(String pollution) {
		this.pollution = pollution;
	}

	public String getWaterLevelChange() {
		return this.waterLevelChange;
	}

	public void setWaterLevelChange(String waterLevelChange) {
		this.waterLevelChange = waterLevelChange;
	}

	public String getSlope() {
		return this.slope;
	}

	public void setSlope(String slope) {
		this.slope = slope;
	}

	public String getFlowSpeed() {
		return this.flowSpeed;
	}

	public void setFlowSpeed(String flowSpeed) {
		this.flowSpeed = flowSpeed;
	}

	public String getCurvature() {
		return this.curvature;
	}

	public void setCurvature(String curvature) {
		this.curvature = curvature;
	}

	public String getBestVisitTime() {
		return this.bestVisitTime;
	}

	public void setBestVisitTime(String bestVisitTime) {
		this.bestVisitTime = bestVisitTime;
	}

	public String getVisitMethod() {
		return this.visitMethod;
	}

	public void setVisitMethod(String visitMethod) {
		this.visitMethod = visitMethod;
	}

	public String getFloatCondition() {
		return this.floatCondition;
	}

	public void setFloatCondition(String floatCondition) {
		this.floatCondition = floatCondition;
	}

	public String getLen() {
		return this.len;
	}

	public void setLen(String len) {
		this.len = len;
	}

	public String getGap() {
		return this.gap;
	}

	public void setGap(String gap) {
		this.gap = gap;
	}

	public String getDownWaterLevel() {
		return this.downWaterLevel;
	}

	public void setDownWaterLevel(String downWaterLevel) {
		this.downWaterLevel = downWaterLevel;
	}

	public String getDrySeasonFlow() {
		return this.drySeasonFlow;
	}

	public void setDrySeasonFlow(String drySeasonFlow) {
		this.drySeasonFlow = drySeasonFlow;
	}

	public String getWaterfallType() {
		return this.waterfallType;
	}

	public void setWaterfallType(String waterfallType) {
		this.waterfallType = waterfallType;
	}

	public String getAvgFlow() {
		return this.avgFlow;
	}

	public void setAvgFlow(String avgFlow) {
		this.avgFlow = avgFlow;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getSpringType() {
		return this.springType;
	}

	public void setSpringType(String springType) {
		this.springType = springType;
	}

}