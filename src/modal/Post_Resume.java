package modal;

public class Post_Resume
{
	private String name;
	private String address;
	private String email_id;
	private int work_exp;
	private int t_marks;
	private int tw_marks;
	private int g_marks;
	private int p_marks;
	private String skill;
	private String pro_1;
	private String pro_2;
	private String references;
	private String user_id;
	
	public Post_Resume()
	{}
	
	public Post_Resume(String name, String address, String email_id, int work_exp, int t_marks,
			int tw_marks, int g_marks, int p_marks, String skill, String pro_1, String pro_2,
			String references,String user_id) 
	{
		this.name = name;
		this.address = address;
		this.email_id = email_id;
		this.work_exp = work_exp;
		this.t_marks = t_marks;
		this.tw_marks = tw_marks;
		this.g_marks = g_marks;
		this.p_marks = p_marks;
		this.skill = skill;
		this.pro_1 = pro_1;
		this.pro_2 = pro_2;
		this.references = references;
		this.user_id=user_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public int getWork_exp() {
		return work_exp;
	}
	public void setWork_exp(int work_exp) {
		this.work_exp = work_exp;
	}
	public int getT_marks() {
		return t_marks;
	}
	public void setT_marks(int t_marks) {
		this.t_marks = t_marks;
	}
	public int getTw_marks() {
		return tw_marks;
	}
	public void setTw_marks(int tw_marks) {
		this.tw_marks = tw_marks;
	}
	public int getG_marks() {
		return g_marks;
	}
	public void setG_marks(int g_marks) {
		this.g_marks = g_marks;
	}
	public int getP_marks() {
		return p_marks;
	}
	public void setP_marks(int p_marks) {
		this.p_marks = p_marks;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String getPro_1() {
		return pro_1;
	}
	public void setPro_1(String pro_1) {
		this.pro_1 = pro_1;
	}
	public String getPro_2() {
		return pro_2;
	}
	public void setPro_2(String pro_2) {
		this.pro_2 = pro_2;
	}
	public String getReferences() {
		return references;
	}
	public void setReferences(String references) {
		this.references = references;
	}
}
