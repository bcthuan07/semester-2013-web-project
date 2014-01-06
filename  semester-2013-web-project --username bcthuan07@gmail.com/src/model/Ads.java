/**
 * 
 */
package model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Thuan
 *
 */
@Entity
@Table(name="ads")
public class Ads implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String content;
	private String imagePath;
	private String name;
	private String link;
	public Ads(Integer id, String content, String imagePath, String name, String link) {
		super();
		this.id = id;
		this.content = content;
		this.imagePath = imagePath;
		this.name = name;
		this.link = link;
	}
	
	public Ads() {
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="ad_id",nullable=false,unique=true)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="content",nullable=false)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name="image_path",nullable=false)
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Column(name="name",nullable=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="link",nullable=false)
	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	
	
	
}
