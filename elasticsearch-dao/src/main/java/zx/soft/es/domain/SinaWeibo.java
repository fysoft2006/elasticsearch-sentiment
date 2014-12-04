package zx.soft.es.domain;

public class SinaWeibo {
	private String wid;
	private long username;
	private int repostscount;
	private int commentscount;
	private String text;
	private long createat;
	private String owid;
	private long ousername;
	private boolean favorited;
	private String originalpic;

	private long lasttime;
	private String id;
	private String geo;
	private String source;
	private boolean visible;
	private float latitude;
	private float longitude;

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	public long getUsername() {
		return username;
	}

	public void setUsername(long username) {
		this.username = username;
	}

	public int getRepostscount() {
		return repostscount;
	}

	public void setRepostscount(int repostscount) {
		this.repostscount = repostscount;
	}

	public int getCommentscount() {
		return commentscount;
	}

	public void setCommentscount(int commentscount) {
		this.commentscount = commentscount;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getCreateat() {
		return createat;
	}

	public void setCreateat(long createat) {
		this.createat = createat;
	}

	public String getOwid() {
		return owid;
	}

	public void setOwid(String owid) {
		this.owid = owid;
	}

	public long getOusername() {
		return ousername;
	}

	public void setOusername(long ousername) {
		this.ousername = ousername;
	}

	public boolean isFavorited() {
		return favorited;
	}

	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}

	public String getOriginalpic() {
		return originalpic;
	}

	public void setOriginalpic(String originalpic) {
		this.originalpic = originalpic;
	}

	public long getLasttime() {
		return lasttime;
	}

	public void setLasttime(long lasttime) {
		this.lasttime = lasttime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGeo() {
		return geo;
	}

	public void setGeo(String geo) {
		this.geo = geo;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "wid =" + wid + ";username =" + username + ";repostscount =" + repostscount + ";commentscount ="
				+ commentscount + ";text =" + text + ";createat =" + createat + ";owid =" + owid + ";ousername ="
				+ ousername + ";favorited =" + favorited + ";originalpic =" + originalpic + ";lasttime =" + lasttime
				+ ";id =" + id + ";geo =" + geo + ";source =" + source + ";visible =" + visible + ";latitude ="
				+ latitude + ";longitude =" + longitude;
	}
}
