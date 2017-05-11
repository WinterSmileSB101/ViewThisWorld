package winter.zxb.smilesb101.viewthisworld.Bean;

import java.io.Serializable;

/**
 * 项目名称：ViewThisWorld
 * 类描述：易源新闻bean类
 * 创建人：SmileSB101
 * 创建时间：2017/5/8 0008 09:20
 * 修改人：Administrator
 * 修改时间：2017/5/8 0008 09:20
 * 修改备注：
 */

public class YiYuanNewsBean implements Serializable{
	String id;
	boolean havePic;
	String pubDate;
	String title;
	String channelName;
	String content;//正文
	String[] imageurls;//json {height,width,url }数组
	String desc;
	String source;
	String channelId;
	String link;
	String html;//正文
	String nid;//外网新闻id

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public boolean isHavePic(){
		return havePic;
	}

	public void setHavePic(boolean havePic){
		this.havePic = havePic;
	}

	public String getPubDate(){
		return pubDate;
	}

	public void setPubDate(String pubDate){
		this.pubDate = pubDate;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getChannelName(){
		return channelName;
	}

	public void setChannelName(String channelName){
		this.channelName = channelName;
	}

	public String getContent(){
		return content;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String[] getImageurls(){
		return imageurls;
	}

	public void setImageurls(String[] imageurls){
		this.imageurls = imageurls;
	}

	public String getDesc(){
		return desc;
	}

	public void setDesc(String desc){
		this.desc = desc;
	}

	public String getSource(){
		return source;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getChannelId(){
		return channelId;
	}

	public void setChannelId(String channelId){
		this.channelId = channelId;
	}

	public String getLink(){
		return link;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getHtml(){
		return html;
	}

	public void setHtml(String html){
		this.html = html;
	}

	public String getNid(){
		return nid;
	}

	public void setNid(String nid){
		this.nid = nid;
	}
}
