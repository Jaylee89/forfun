package com.fbty.androidgrimp.domain;

// default package


/**
 * Section entity. @author MyEclipse Persistence Tools
 */

public class Section implements java.io.Serializable {

	// Fields
    
	private Integer id;
	/**名称*/
	private String name;
	/**遗迹编号*/
	private String number;
	/**野外编号*/
	private String wildNumber;
	/**地理位置*/ 
	private String  firstLocation;
	/**地区*/
	private String lastLocation;
	/**观测点地理位置*/
	private String  observeFirstLocation;
	/**观测点地区*/
	private String observeLastLocation;
	/**调查时间*/
	private String searchTime;
	/**观测点高度*/
	private String viewHeight;
	/**遗迹经度*/
	private String longitude;
	/**遗迹纬度*/
	private String latitude;
	/**观测点经度*/
	private String coordinatesX;
	/**观测点纬度*/
	private String coordinatesY;
	/**交通状况*/
	private String trafficState;
	/**交通状况描述*/
	private String trafficState2;
	/**资料来源*/
	private String dataHead;
	/**地质背景*/
	private String backdrop;
	/**底层代号*/
	private String stratumSymbol;
	/**地质年代*/
	private String geoYear;
	/**发现和命名时间*/
	private String firstTime;
	/**发现和命名人*/
	private String firstHuman;
	/**调查人员*/
	private String inquirerHuman;
	/**保护现状*/
	private String protectActuality;
	/**保护建议*/
	private String protectActualityDesc;
	/**开发现状*/
	private String developmentActuality;
	/**开发建议*/
	private String developmentActualityDesc;
	/**成因*/
	private String causes;
	/**形态特征*/
	private String shape;
	/**备注*/
	private String remark;
	/**科学研究价值*/
	private String scienceStudy;
	/**科教与科普价值*/
	private String sciencePopular;
	/**典型性*/
	private String scienceTypical;
	/**稀有性*/
	private String scienceRare;
	/**完整性*/
	private String scienceComplete;
	/**资源容量*/
	private String scienceCapacity;
	/**自然地理条件*/
	private String natureGeography;
	/**旅游季节性*/
	private String natureTravel;
	/**环境质量*/
	private String natureQuality;
	/**脆弱性*/
	private String natureFragile;
	/**安全性*/
	private String natureSecurity;
	/**形象美*/
	private String viewImage;
	/**色彩美*/
	private String viewColor;
	/**动态性*/
	private String viewDynamic;
	/**愉悦性*/
	private String viewPleasure;
	/**奇特性和奇异性*/
	private String viewStrange;
	/**资源规模和组合*/
	private String viewScale;
	/**点号*/
	private String point;
	/**观测高程*/
	private String highRange;
	/**剖面长度*/
	private String sectionLength;
	/**出露面积*/
	private String emergenceArea;
	/**出露宽度*/
	private String thickness;
	/**出露长度*/
	private String length;
	/**产状*/
	private String lithoface;
	/**地层层序*/
	private String stratumSequence;
	/**露头宽度*/
	private String emergenceWidth;
	/**露头长度*/
	private String emergenceLength;
	/**岩性*/
	private String yanxing;
	/**方向*/
	private String direction;
	/**级别*/
	private String levels;
	/**所含主要化石*/
	private String incurredMainStroe;
	/**是否是观测点*/
	private int isEnd;
	/**照片文件夹*/
	private String img;
	/**视频文件路径*/
	private String video;
	/**类别*/
	private String type;
	/**数据是否已经上传*/
	private int isData;
	/**照片是否已经上传*/
	private int isPhoto;
	/**视频是否已经上传*/
	private int isVideo;
	
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	/**
	 * @return the wildNumber
	 */
	public String getWildNumber() {
		return wildNumber;
	}
	/**
	 * @param wildNumber the wildNumber to set
	 */
	public void setWildNumber(String wildNumber) {
		this.wildNumber = wildNumber;
	}
	/**
	 * @return the firstlLocation
	 */
	public String getFirstLocation() {
		return firstLocation;
	}
	/**
	 * @param firstlLocation the firstlLocation to set
	 */
	public void setFirstLocation(String firstLocation) {
		this.firstLocation = firstLocation;
	}
	/**
	 * @return the lastLocation
	 */
	public String getLastLocation() {
		return lastLocation;
	}
	/**
	 * @param lastLocation the lastLocation to set
	 */
	public void setLastLocation(String lastLocation) {
		this.lastLocation = lastLocation;
	}
	
	public String getSearchTime() {
		return searchTime;
	}
	public void setSearchTime(String searchTime) {
		this.searchTime = searchTime;
	}
	/**
	 * @return the viewHeight
	 */
	public String getViewHeight() {
		return viewHeight;
	}
	/**
	 * @param viewHeight the viewHeight to set
	 */
	public void setViewHeight(String viewHeight) {
		this.viewHeight = viewHeight;
	}
	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the coordinatesX
	 */
	public String getCoordinatesX() {
		return coordinatesX;
	}
	/**
	 * @param coordinatesX the coordinatesX to set
	 */
	public void setCoordinatesX(String coordinatesX) {
		this.coordinatesX = coordinatesX;
	}
	/**
	 * @return the coordinatesY
	 */
	public String getCoordinatesY() {
		return coordinatesY;
	}
	/**
	 * @param coordinatesY the coordinatesY to set
	 */
	public void setCoordinatesY(String coordinatesY) {
		this.coordinatesY = coordinatesY;
	}
	/**
	 * @return the trafficState
	 */
	public String getTrafficState() {
		return trafficState;
	}
	/**
	 * @param trafficState the trafficState to set
	 */
	public void setTrafficState(String trafficState) {
		this.trafficState = trafficState;
	}
	/**
	 * @return the dataHead
	 */
	public String getDataHead() {
		return dataHead;
	}
	/**
	 * @param dataHead the dataHead to set
	 */
	public void setDataHead(String dataHead) {
		this.dataHead = dataHead;
	}
	/**
	 * @return the backdrop
	 */
	public String getBackdrop() {
		return backdrop;
	}
	/**
	 * @param backdrop the backdrop to set
	 */
	public void setBackdrop(String backdrop) {
		this.backdrop = backdrop;
	}
	/**
	 * @return the stratumSymbol
	 */
	public String getStratumSymbol() {
		return stratumSymbol;
	}
	/**
	 * @param stratumSymbol the stratumSymbol to set
	 */
	public void setStratumSymbol(String stratumSymbol) {
		this.stratumSymbol = stratumSymbol;
	}
	/**
	 * @return the geoYear
	 */
	public String getGeoYear() {
		return geoYear;
	}
	/**
	 * @param geoYear the geoYear to set
	 */
	public void setGeoYear(String geoYear) {
		this.geoYear = geoYear;
	}
	
	public String getFirstTime() {
		return firstTime;
	}
	public void setFirstTime(String firstTime) {
		this.firstTime = firstTime;
	}
	/**
	 * @return the firstHuman
	 */
	public String getFirstHuman() {
		return firstHuman;
	}
	/**
	 * @param firstHuman the firstHuman to set
	 */
	public void setFirstHuman(String firstHuman) {
		this.firstHuman = firstHuman;
	}
	/**
	 * @return the inquirerHuman
	 */
	public String getInquirerHuman() {
		return inquirerHuman;
	}
	/**
	 * @param inquirerHuman the inquirerHuman to set
	 */
	public void setInquirerHuman(String inquirerHuman) {
		this.inquirerHuman = inquirerHuman;
	}
	/**
	 * @return the protectActuality
	 */
	public String getProtectActuality() {
		return protectActuality;
	}
	/**
	 * @param protectActuality the protectActuality to set
	 */
	public void setProtectActuality(String protectActuality) {
		this.protectActuality = protectActuality;
	}
	/**
	 * @return the protectActualityDesc
	 */
	public String getProtectActualityDesc() {
		return protectActualityDesc;
	}
	/**
	 * @param protectActualityDesc the protectActualityDesc to set
	 */
	public void setProtectActualityDesc(String protectActualityDesc) {
		this.protectActualityDesc = protectActualityDesc;
	}
	/**
	 * @return the developmentActuality
	 */
	public String getDevelopmentActuality() {
		return developmentActuality;
	}
	/**
	 * @param developmentActuality the developmentActuality to set
	 */
	public void setDevelopmentActuality(String developmentActuality) {
		this.developmentActuality = developmentActuality;
	}
	/**
	 * @return the developmentActualityDesc
	 */
	public String getDevelopmentActualityDesc() {
		return developmentActualityDesc;
	}
	/**
	 * @param developmentActualityDesc the developmentActualityDesc to set
	 */
	public void setDevelopmentActualityDesc(String developmentActualityDesc) {
		this.developmentActualityDesc = developmentActualityDesc;
	}
	/**
	 * @return the causes
	 */
	public String getCauses() {
		return causes;
	}
	/**
	 * @param causes the causes to set
	 */
	public void setCauses(String causes) {
		this.causes = causes;
	}
	/**
	 * @return the shape
	 */
	public String getShape() {
		return shape;
	}
	/**
	 * @param shape the shape to set
	 */
	public void setShape(String shape) {
		this.shape = shape;
	}
	/**
	 * @return the remark
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * @param remark the remark to set
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * @return the scienceStudy
	 */
	public String getScienceStudy() {
		return scienceStudy;
	}
	/**
	 * @param scienceStudy the scienceStudy to set
	 */
	public void setScienceStudy(String scienceStudy) {
		this.scienceStudy = scienceStudy;
	}
	/**
	 * @return the sciencePopular
	 */
	public String getSciencePopular() {
		return sciencePopular;
	}
	/**
	 * @param sciencePopular the sciencePopular to set
	 */
	public void setSciencePopular(String sciencePopular) {
		this.sciencePopular = sciencePopular;
	}
	/**
	 * @return the scienceTypical
	 */
	public String getScienceTypical() {
		return scienceTypical;
	}
	/**
	 * @param scienceTypical the scienceTypical to set
	 */
	public void setScienceTypical(String scienceTypical) {
		this.scienceTypical = scienceTypical;
	}
	/**
	 * @return the scienceRare
	 */
	public String getScienceRare() {
		return scienceRare;
	}
	/**
	 * @param scienceRare the scienceRare to set
	 */
	public void setScienceRare(String scienceRare) {
		this.scienceRare = scienceRare;
	}
	/**
	 * @return the scienceComplete
	 */
	public String getScienceComplete() {
		return scienceComplete;
	}
	/**
	 * @param scienceComplete the scienceComplete to set
	 */
	public void setScienceComplete(String scienceComplete) {
		this.scienceComplete = scienceComplete;
	}
	/**
	 * @return the scienceCapacity
	 */
	public String getScienceCapacity() {
		return scienceCapacity;
	}
	/**
	 * @param scienceCapacity the scienceCapacity to set
	 */
	public void setScienceCapacity(String scienceCapacity) {
		this.scienceCapacity = scienceCapacity;
	}
	/**
	 * @return the natureGeography
	 */
	public String getNatureGeography() {
		return natureGeography;
	}
	/**
	 * @param natureGeography the natureGeography to set
	 */
	public void setNatureGeography(String natureGeography) {
		this.natureGeography = natureGeography;
	}
	/**
	 * @return the natureTravel
	 */
	public String getNatureTravel() {
		return natureTravel;
	}
	/**
	 * @param natureTravel the natureTravel to set
	 */
	public void setNatureTravel(String natureTravel) {
		this.natureTravel = natureTravel;
	}
	/**
	 * @return the natureQuality
	 */
	public String getNatureQuality() {
		return natureQuality;
	}
	/**
	 * @param natureQuality the natureQuality to set
	 */
	public void setNatureQuality(String natureQuality) {
		this.natureQuality = natureQuality;
	}
	/**
	 * @return the natureFragile
	 */
	public String getNatureFragile() {
		return natureFragile;
	}
	/**
	 * @param natureFragile the natureFragile to set
	 */
	public void setNatureFragile(String natureFragile) {
		this.natureFragile = natureFragile;
	}
	/**
	 * @return the natureSecurity
	 */
	public String getNatureSecurity() {
		return natureSecurity;
	}
	/**
	 * @param natureSecurity the natureSecurity to set
	 */
	public void setNatureSecurity(String natureSecurity) {
		this.natureSecurity = natureSecurity;
	}
	/**
	 * @return the viewImage
	 */
	public String getViewImage() {
		return viewImage;
	}
	/**
	 * @param viewImage the viewImage to set
	 */
	public void setViewImage(String viewImage) {
		this.viewImage = viewImage;
	}
	/**
	 * @return the viewColor
	 */
	public String getViewColor() {
		return viewColor;
	}
	/**
	 * @param viewColor the viewColor to set
	 */
	public void setViewColor(String viewColor) {
		this.viewColor = viewColor;
	}
	/**
	 * @return the viewDynamic
	 */
	public String getViewDynamic() {
		return viewDynamic;
	}
	/**
	 * @param viewDynamic the viewDynamic to set
	 */
	public void setViewDynamic(String viewDynamic) {
		this.viewDynamic = viewDynamic;
	}
	/**
	 * @return the viewPleasure
	 */
	public String getViewPleasure() {
		return viewPleasure;
	}
	/**
	 * @param viewPleasure the viewPleasure to set
	 */
	public void setViewPleasure(String viewPleasure) {
		this.viewPleasure = viewPleasure;
	}
	/**
	 * @return the viewStrange
	 */
	public String getViewStrange() {
		return viewStrange;
	}
	/**
	 * @param viewStrange the viewStrange to set
	 */
	public void setViewStrange(String viewStrange) {
		this.viewStrange = viewStrange;
	}
	/**
	 * @return the viewScale
	 */
	public String getViewScale() {
		return viewScale;
	}
	/**
	 * @param viewScale the viewScale to set
	 */
	public void setViewScale(String viewScale) {
		this.viewScale = viewScale;
	}
	/**
	 * @return the sectionLength
	 */
	public String getSectionLength() {
		return sectionLength;
	}
	/**
	 * @param sectionLength the sectionLength to set
	 */
	public void setSectionLength(String sectionLength) {
		this.sectionLength = sectionLength;
	}
	/**
	 * @return the emergenceArea
	 */
	public String getEmergenceArea() {
		return emergenceArea;
	}
	/**
	 * @param emergenceArea the emergenceArea to set
	 */
	public void setEmergenceArea(String emergenceArea) {
		this.emergenceArea = emergenceArea;
	}
	/**
	 * @return the thickness
	 */
	public String getThickness() {
		return thickness;
	}
	/**
	 * @param thickness the thickness to set
	 */
	public void setThickness(String thickness) {
		this.thickness = thickness;
	}
	/**
	 * @return the lithoface
	 */
	public String getLithoface() {
		return lithoface;
	}
	/**
	 * @param lithoface the lithoface to set
	 */
	public void setLithoface(String lithoface) {
		this.lithoface = lithoface;
	}
	/**
	 * @return the stratumSequence
	 */
	public String getStratumSequence() {
		return stratumSequence;
	}
	/**
	 * @param stratumSequence the stratumSequence to set
	 */
	public void setStratumSequence(String stratumSequence) {
		this.stratumSequence = stratumSequence;
	}
	/**
	 * @return the emergenceWidth
	 */
	public String getEmergenceWidth() {
		return emergenceWidth;
	}
	/**
	 * @param emergenceWidth the emergenceWidth to set
	 */
	public void setEmergenceWidth(String emergenceWidth) {
		this.emergenceWidth = emergenceWidth;
	}
	/**
	 * @return the emergenceLength
	 */
	public String getEmergenceLength() {
		return emergenceLength;
	}
	/**
	 * @param emergenceLength the emergenceLength to set
	 */
	public void setEmergenceLength(String emergenceLength) {
		this.emergenceLength = emergenceLength;
	}
	/**
	 * @return the yanxing
	 */
	public String getYanxing() {
		return yanxing;
	}
	/**
	 * @param yanxing the yanxing to set
	 */
	public void setYanxing(String yanxing) {
		this.yanxing = yanxing;
	}
	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}
	/**
	 * @param direction the direction to set
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}
	/**
	 * @return the levels
	 */
	public String getLevels() {
		return levels;
	}
	/**
	 * @param levels the levels to set
	 */
	public void setLevels(String levels) {
		this.levels = levels;
	}
	/**
	 * @return the incurredMainStroe
	 */
	public String getIncurredMainStroe() {
		return incurredMainStroe;
	}
	/**
	 * @param incurredMainStroe the incurredMainStroe to set
	 */
	public void setIncurredMainStroe(String incurredMainStroe) {
		this.incurredMainStroe = incurredMainStroe;
	}
	/**
	 * @return the isEnd
	 */
	public int isEnd() {
		return isEnd;
	}
	/**
	 * @param isEnd the isEnd to set
	 */
	public void setEnd(int isEnd) {
		this.isEnd = isEnd;
	}
	
	
	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}
	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}
	/**
	 * @return the video
	 */
	public String getVideo() {
		return video;
	}
	/**
	 * @param video the video to set
	 */
	public void setVideo(String video) {
		this.video = video;
	}
	
	
	public String getObserveFirstLocation() {
		return observeFirstLocation;
	}
	public void setObserveFirstLocation(String observeFirstLocation) {
		this.observeFirstLocation = observeFirstLocation;
	}
	public String getObserveLastLocation() {
		return observeLastLocation;
	}
	public void setObserveLastLocation(String observeLastLocation) {
		this.observeLastLocation = observeLastLocation;
	}
	public Section(Integer id, String name, String number, String wildNumber,
			String firstLocation, String lastLocation, String searchTime,
			String viewHeight, String longitude, String latitude,
			String coordinatesX, String coordinatesY, String trafficState,
			String dataHead, String backdrop, String stratumSymbol,
			String geoYear, String firstTime, String firstHuman,
			String inquirerHuman, String protectActuality,
			String protectActualityDesc, String developmentActuality,
			String developmentActualityDesc, String causes, String shape,
			String remark, String scienceStudy, String sciencePopular,
			String scienceTypical, String scienceRare, String scienceComplete,
			String scienceCapacity, String natureGeography,
			String natureTravel, String natureQuality, String natureFragile,
			String natureSecurity, String viewImage, String viewColor,
			String viewDynamic, String viewPleasure, String viewStrange,
			String viewScale, String sectionLength, String emergenceArea,
			String thickness, String lithoface, String stratumSequence,
			String emergenceWidth, String emergenceLength, String yanxing,
			String direction, String levels, String incurredMainStroe,
			int isEnd) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.wildNumber = wildNumber;
		this.firstLocation = firstLocation;
		this.lastLocation = lastLocation;
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
		this.sectionLength = sectionLength;
		this.emergenceArea = emergenceArea;
		this.thickness = thickness;
		this.lithoface = lithoface;
		this.stratumSequence = stratumSequence;
		this.emergenceWidth = emergenceWidth;
		this.emergenceLength = emergenceLength;
		this.yanxing = yanxing;
		this.direction = direction;
		this.levels = levels;
		this.incurredMainStroe = incurredMainStroe;
		this.isEnd = isEnd;
	}
	public Section() {
		super();
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Section [backdrop=" + backdrop + ", causes=" + causes
				+ ", coordinatesX=" + coordinatesX + ", coordinatesY="
				+ coordinatesY + ", dataHead=" + dataHead
				+ ", developmentActuality=" + developmentActuality
				+ ", developmentActualityDesc=" + developmentActualityDesc
				+ ", direction=" + direction + ", emergenceArea="
				+ emergenceArea + ", emergenceLength=" + emergenceLength
				+ ", emergenceWidth=" + emergenceWidth + ", firstHuman="
				+ firstHuman + ", firstTime=" + firstTime + ", firstlLocation="
				+ firstLocation + ", geoYear=" + geoYear + ", id=" + id
				+ ", incurredMainStroe=" + incurredMainStroe
				+ ", inquirerHuman=" + inquirerHuman + ", isEnd=" + isEnd
				+ ", lastLocation=" + lastLocation + ", latitude=" + latitude
				+ ", levels=" + levels + ", lithoface=" + lithoface
				+ ", longitude=" + longitude + ", name=" + name
				+ ", natureFragile=" + natureFragile + ", natureGeography="
				+ natureGeography + ", natureQuality=" + natureQuality
				+ ", natureSecurity=" + natureSecurity + ", natureTravel="
				+ natureTravel + ", number=" + number + ", protectActuality="
				+ protectActuality + ", protectActualityDesc="
				+ protectActualityDesc + ", remark=" + remark
				+ ", scienceCapacity=" + scienceCapacity + ", scienceComplete="
				+ scienceComplete + ", sciencePopular=" + sciencePopular
				+ ", scienceRare=" + scienceRare + ", scienceStudy="
				+ scienceStudy + ", scienceTypical=" + scienceTypical
				+ ", searchTime=" + searchTime + ", sectionLength="
				+ sectionLength + ", shape=" + shape + ", stratumSequence="
				+ stratumSequence + ", stratumSymbol=" + stratumSymbol
				+ ", thickness=" + thickness + ", trafficState=" + trafficState
				+ ", viewColor=" + viewColor + ", viewDynamic=" + viewDynamic
				+ ", viewHeight=" + viewHeight + ", viewImage=" + viewImage
				+ ", viewPleasure=" + viewPleasure + ", viewScale=" + viewScale
				+ ", viewStrange=" + viewStrange + ", wildNumber=" + wildNumber
				+ ", yanxing=" + yanxing + "]";
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getLength() {
		return length;
	}
	public void setHighRange(String highRange) {
		this.highRange = highRange;
	}
	public String getHighRange() {
		return highRange;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public String getPoint() {
		return point;
	}
	public void setTrafficState2(String trafficState2) {
		this.trafficState2 = trafficState2;
	}
	public String getTrafficState2() {
		return trafficState2;
	}
	public int getIsEnd() {
		return isEnd;
	}
	public void setIsEnd(int isEnd) {
		this.isEnd = isEnd;
	}
	public void setIsData(int isData) {
		this.isData = isData;
	}
	public int getIsData() {
		return isData;
	}
	public void setIsPhoto(int isPhoto) {
		this.isPhoto = isPhoto;
	}
	public int getIsPhoto() {
		return isPhoto;
	}
	public void setIsVideo(int isVideo) {
		this.isVideo = isVideo;
	}
	public int getIsVideo() {
		return isVideo;
	}

}