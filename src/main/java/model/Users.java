package model;

public class Users  extends Role{
	private int idUser;
	private String username, password, image;
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int id) {
		this.idUser = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public Users() {
		
	}
	
	public Users( String username, String password) {
	
		this.username = username;
		this.password = password;
	}
	public Users( int idUser, String username, String password, String image,int id) {
		super(id);
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.image = image;
	}
	public Users( String username, String password, String image,int id) {
		super(id);
		this.username = username;
		this.password = password;
		this.image = image;
	}
	@Override
	public String toString() {
		return "Users [idUser=" + idUser + ", username=" + username + ", password=" + password + ", image=" + image
				+ "]";
	}
	
	

}
