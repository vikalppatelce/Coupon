package demo.vicshady.coupondunia.dto;

public class CouponsDTO {
	
	public String CouponID;
	public String CouponCode;
	public String CountSuccess;
	public String CountFail;
	public String Hits;
	public String Discount;
	public String Title;
	public String Description;
	public String WebsiteID;
	public String Expiry;
	public String DateVerified;
	public String Priority;
	public String IsOneTimeUse;
	public String IsDeal;
	public String CouponPopularityScore;
	public String FullTerms;
	public String FeaturedCouponRank;
	public String AccessCode;
	public String WebsiteName;
	public String WebsiteTitle;
	public String LandingPageURL;
	public String ImageURL;
	
	public String CategoryName;
	public String URLKeyword;
	
	
	
	public CouponsDTO(String couponID, String couponCode, String countSuccess,
			String countFail, String hits, String discount, String title,
			String description, String websiteID, String expiry,
			String dateVerified, String priority, String isOneTimeUse,
			String isDeal, String couponPopularityScore, String fullTerms,
			String featuredCouponRank, String accessCode, String websiteName,
			String websiteTitle, String landingPageURL, String imageURL,
			String categoryName, String uRLKeyword) {
		super();
		CouponID = couponID;
		CouponCode = couponCode;
		CountSuccess = countSuccess;
		CountFail = countFail;
		Hits = hits;
		Discount = discount;
		Title = title;
		Description = description;
		WebsiteID = websiteID;
		Expiry = expiry;
		DateVerified = dateVerified;
		Priority = priority;
		IsOneTimeUse = isOneTimeUse;
		IsDeal = isDeal;
		CouponPopularityScore = couponPopularityScore;
		FullTerms = fullTerms;
		FeaturedCouponRank = featuredCouponRank;
		AccessCode = accessCode;
		WebsiteName = websiteName;
		WebsiteTitle = websiteTitle;
		LandingPageURL = landingPageURL;
		ImageURL = imageURL;
		CategoryName = categoryName;
		URLKeyword = uRLKeyword;
	}
	public CouponsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCouponID() {
		return CouponID;
	}
	public void setCouponID(String couponID) {
		CouponID = couponID;
	}
	public String getCouponCode() {
		return CouponCode;
	}
	public void setCouponCode(String couponCode) {
		CouponCode = couponCode;
	}
	public String getCountSuccess() {
		return CountSuccess;
	}
	public void setCountSuccess(String countSuccess) {
		CountSuccess = countSuccess;
	}
	public String getCountFail() {
		return CountFail;
	}
	public void setCountFail(String countFail) {
		CountFail = countFail;
	}
	public String getHits() {
		return Hits;
	}
	public void setHits(String hits) {
		Hits = hits;
	}
	public String getDiscount() {
		return Discount;
	}
	public void setDiscount(String discount) {
		Discount = discount;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getWebsiteID() {
		return WebsiteID;
	}
	public void setWebsiteID(String websiteID) {
		WebsiteID = websiteID;
	}
	public String getExpiry() {
		return Expiry;
	}
	public void setExpiry(String expiry) {
		Expiry = expiry;
	}
	public String getDateVerified() {
		return DateVerified;
	}
	public void setDateVerified(String dateVerified) {
		DateVerified = dateVerified;
	}
	public String getPriority() {
		return Priority;
	}
	public void setPriority(String priority) {
		Priority = priority;
	}
	public String getIsOneTimeUse() {
		return IsOneTimeUse;
	}
	public void setIsOneTimeUse(String isOneTimeUse) {
		IsOneTimeUse = isOneTimeUse;
	}
	public String getIsDeal() {
		return IsDeal;
	}
	public void setIsDeal(String isDeal) {
		IsDeal = isDeal;
	}
	public String getCouponPopularityScore() {
		return CouponPopularityScore;
	}
	public void setCouponPopularityScore(String couponPopularityScore) {
		CouponPopularityScore = couponPopularityScore;
	}
	public String getFullTerms() {
		return FullTerms;
	}
	public void setFullTerms(String fullTerms) {
		FullTerms = fullTerms;
	}
	public String getFeaturedCouponRank() {
		return FeaturedCouponRank;
	}
	public void setFeaturedCouponRank(String featuredCouponRank) {
		FeaturedCouponRank = featuredCouponRank;
	}
	public String getAccessCode() {
		return AccessCode;
	}
	public void setAccessCode(String accessCode) {
		AccessCode = accessCode;
	}
	public String getWebsiteName() {
		return WebsiteName;
	}
	public void setWebsiteName(String websiteName) {
		WebsiteName = websiteName;
	}
	public String getWebsiteTitle() {
		return WebsiteTitle;
	}
	public void setWebsiteTitle(String websiteTitle) {
		WebsiteTitle = websiteTitle;
	}
	public String getLandingPageURL() {
		return LandingPageURL;
	}
	public void setLandingPageURL(String landingPageURL) {
		LandingPageURL = landingPageURL;
	}
	public String getImageURL() {
		return ImageURL;
	}
	public void setImageURL(String imageURL) {
		ImageURL = imageURL;
	}
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public String getURLKeyword() {
		return URLKeyword;
	}
	public void setURLKeyword(String uRLKeyword) {
		URLKeyword = uRLKeyword;
	}
}
