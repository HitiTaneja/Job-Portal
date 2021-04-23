package modal;

public class Employee 
{
	private String emp_id;
	private String f_name;
	private String m_name;
	private String l_name;
	private String email;
	private String com_name;
	private String e_password;
	
	
	public Employee(String emp_id, String f_name, String m_name, String l_name, String email, String com_name, String e_password) 
	{
		this.emp_id = emp_id;
		this.f_name = f_name;
		this.m_name = m_name;
		this.l_name = l_name;
		this.email = email;
		this.com_name = com_name;
		this.e_password = e_password;				
	}
	public Employee() 
	{}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
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
	public String getCom_name() {
		return com_name;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public String getE_password() {
		return e_password;
	}
	public void setE_password(String e_password) {
		this.e_password = e_password;
	}


}
