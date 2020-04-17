package resource.bean.basic;

/**
 * excel列表
 * 
 * @author jason.mao
 *
 */
@SuppressWarnings("ucd")
public class TlrUpdateInfoUploadBean {
    private String userId;
    private String city;
    private String region;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	@Override
	public String toString() {
		return "TlrUpdateInfoUploadBean [userId=" + userId + ", city=" + city
				+ ", region=" + region + "]";
	}
	public TlrUpdateInfoUploadBean(String userId, String city, String region) {
		super();
		this.userId = userId;
		this.city = city;
		this.region = region;
	}
	public TlrUpdateInfoUploadBean() {
		super();
	}

    
}
