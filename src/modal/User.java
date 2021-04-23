package modal;

public class User
{
	private String user_id;
	private String f_name;
	private String m_name;
	private String l_name;
	private String email;
	private String password;
	private int result;
	
	public User()
	{}
	
	public User(String user_id, String f_name, String m_name, String l_name, String email, String password) 
	{
		this.user_id=user_id;
		this.f_name=f_name;
		this.m_name=m_name;
		this.l_name=l_name;
		this.email=email;
		this.password=password;
	}	
	
	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getF_name() {
		return f_name;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
