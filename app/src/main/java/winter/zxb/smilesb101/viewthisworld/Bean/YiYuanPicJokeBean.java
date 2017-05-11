package winter.zxb.smilesb101.viewthisworld.Bean;

/**
 * 项目名称：ViewThisWorld
 * 类描述：易源图片笑话基类
 * 创建人：SmileSB101
 * 创建时间：2017/5/9 0009 19:18
 * 修改人：Administrator
 * 修改时间：2017/5/9 0009 19:18
 * 修改备注：
 */

public class YiYuanPicJokeBean{
	String id;
	String title;
	String img;
	int type;//3 是动态图 2 是静态图
	String ct;

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getImg(){
		return img;
	}

	public void setImg(String img){
		this.img = img;
	}

	public int getType(){
		return type;
	}

	public void setType(int type){
		this.type = type;
	}

	public String getCt(){
		return ct;
	}

	public void setCt(String ct){
		this.ct = ct;
	}
}
