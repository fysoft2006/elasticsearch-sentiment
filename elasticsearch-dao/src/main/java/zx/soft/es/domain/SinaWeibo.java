package zx.soft.es.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sina_user_weibos_1386614765")
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

	public SinaWeibo() {

	}

	public SinaWeibo(String id, String wid, long username, int repostscount, int commentscount, String text,
			long createat, String owid, long ousername, boolean favorited, String geo, float latitude, float longitude,
			String originalpic, String source, boolean visible, long lasttime) {
		this.wid = wid;
		this.username = username;
		this.repostscount = repostscount;
		this.commentscount = commentscount;
		this.text = text;
		this.createat = createat;
		this.owid = owid;
		this.ousername = ousername;
		this.favorited = favorited;
		this.originalpic = originalpic;
		this.lasttime = lasttime;
		this.id = id;
		this.geo = geo;
		this.source = source;
		this.visible = visible;
		this.latitude = latitude;
		this.longitude = longitude;

	}

	@Id
	@Column(name = "wid")
	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

	@Column(name = "username")
	public long getUsername() {
		return username;
	}

	public void setUsername(long username) {
		this.username = username;
	}

	@Column(name = "repostscount")
	public int getRepostscount() {
		return repostscount;
	}

	public void setRepostscount(int repostscount) {
		this.repostscount = repostscount;
	}

	@Column(name = "commentscount")
	public int getCommentscount() {
		return commentscount;
	}

	public void setCommentscount(int commentscount) {
		this.commentscount = commentscount;
	}

	@Column(name = "text")
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column(name = "createat")
	public long getCreateat() {
		return createat;
	}

	public void setCreateat(long createat) {
		this.createat = createat;
	}

	@Column(name = "owid")
	public String getOwid() {
		return owid;
	}

	public void setOwid(String owid) {
		this.owid = owid;
	}

	@Column(name = "ousername")
	public long getOusername() {
		return ousername;
	}

	public void setOusername(long ousername) {
		this.ousername = ousername;
	}

	@Column(name = "favorited")
	public boolean isFavorited() {
		return favorited;
	}

	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}

	@Column(name = "originalpic")
	public String getOriginalpic() {
		return originalpic;
	}

	public void setOriginalpic(String originalpic) {
		this.originalpic = originalpic;
	}

	@Column(name = "lasttime")
	public long getLasttime() {
		return lasttime;
	}

	public void setLasttime(long lasttime) {
		this.lasttime = lasttime;
	}

	@Column(name = "id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "geo")
	public String getGeo() {
		return geo;
	}

	public void setGeo(String geo) {
		this.geo = geo;
	}

	@Column(name = "source")
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(name = "visible")
	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	@Column(name = "latitude")
	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	@Column(name = "longitude")
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
