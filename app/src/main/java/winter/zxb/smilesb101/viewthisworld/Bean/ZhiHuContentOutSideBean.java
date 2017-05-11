package winter.zxb.smilesb101.viewthisworld.Bean;

import java.io.Serializable;

/**
 * 项目名称：ViewThisWorld
 * 类描述：知乎推荐的站外文章(type 为 1 的情况下)
 * 创建人：SmileSB101
 * 创建时间：2017/5/1 0001 22:18
 * 修改人：Administrator
 * 修改时间：2017/5/1 0001 22:18
 * 修改备注：
 */

public class ZhiHuContentOutSideBean implements Serializable{
	String theme_name;
	String title;
	String share_url;
	String[] js;
	String ga_prefix;
	String editor_name;
	String theme_id;
	String type;
	String id;
	String[] css;

	public String getTheme_name(){
		return theme_name;
	}

	public void setTheme_name(String theme_name){
		this.theme_name = theme_name;
	}

	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getShare_url(){
		return share_url;
	}

	public void setShare_url(String share_url){
		this.share_url = share_url;
	}

	public String[] getJs(){
		return js;
	}

	public void setJs(String[] js){
		this.js = js;
	}

	public String getGa_prefix(){
		return ga_prefix;
	}

	public void setGa_prefix(String ga_prefix){
		this.ga_prefix = ga_prefix;
	}

	public String getEditor_name(){
		return editor_name;
	}

	public void setEditor_name(String editor_name){
		this.editor_name = editor_name;
	}

	public String getTheme_id(){
		return theme_id;
	}

	public void setTheme_id(String theme_id){
		this.theme_id = theme_id;
	}

	public String getType(){
		return type;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id;
	}

	public String[] getCss(){
		return css;
	}

	public void setCss(String[] css){
		this.css = css;
	}
}
