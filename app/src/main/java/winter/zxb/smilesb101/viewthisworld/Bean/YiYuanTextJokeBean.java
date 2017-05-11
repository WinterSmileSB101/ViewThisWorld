package winter.zxb.smilesb101.viewthisworld.Bean;

/**
 * 项目名称：ViewThisWorld
 * 类描述：易源文字笑话基类
 * 创建人：SmileSB101
 * 创建时间：2017/5/9 0009 21:16
 * 修改人：Administrator
 * 修改时间：2017/5/9 0009 21:16
 * 修改备注：
 */

public class YiYuanTextJokeBean{
	String id;
	String title;
	String text;
	int type;//1是文字
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

	public String getText(){
		return text;
	}

	public void setText(String text){
		this.text = text;
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
